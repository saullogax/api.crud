package com.saullogax.crud.serviceimpl;

import com.saullogax.crud.entity.Role;
import com.saullogax.crud.models.AuthResponse;
import com.saullogax.crud.models.AuthenticationRequest;
import com.saullogax.crud.models.RegisterRequest;
import com.saullogax.crud.repository.UserRepository;
import com.saullogax.crud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.saullogax.crud.entity.User;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()  //Setea la respuesta del endpoint en user y la guarda en BD
                .usuario(request.getUsuario())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .telefono(request.getTelefono())
                .email(request.getEmail())
                .contrasena(passwordEncoder.encode(request.getContrasena())) //Encripta la contraseña
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder() //Retorna token creado por nosotros
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsuario(),
                        request.getContrasena()
                )
        );
        var user = userRepository.findUserByUsuario(request.getUsuario()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
