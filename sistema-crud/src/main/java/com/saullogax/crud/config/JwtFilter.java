package com.saullogax.crud.config;

import com.saullogax.crud.serviceimpl.JwtServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    private final JwtServiceImpl jwtService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException { //Recibe de parametros los 3 datos necesarios para la autenticacion
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if(authHeader == null || !authHeader.startsWith("Bearer")){ //Valida si la autorizacion es diferente de nulo
                                                                    // o el tipo de autorizacion no empieza con bearer(que es el tipo que estoy usando)
            filterChain.doFilter(request, response);
            return; //Si se cumple alguna de las dos validaciones, devolverá un 403 forbidden
        }
        jwt = authHeader.substring(7); //Comienza en el 7 porque de donde comienza en Bearer, hasta donde está el token son 7 caracteres
        userEmail = jwtService.getUser(jwt);

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){ //Valida que el usuario no este autenticado
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail); //Verifica en la BD si el usuario existe
            if(jwtService.validateToken(jwt, userDetails)){ //Valida si el token es autentico
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
