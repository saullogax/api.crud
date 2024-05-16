package com.saullogax.crud.serviceimpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl { //Claims se utiliza para reclamaciones sobre el token que le mandamos

    private static final String SECRET_KEY = "0f675ce79484bc01fd40954870c4404283fc5f656d20b566216fbff9dfea96c4"; //Es para entorno de desarrollo, se debe configurar en otra parte

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims) //Mandamos las reclamaciones extras
                .setSubject(userDetails.getUsername()) //Mandamos el usuario
                .setIssuedAt(new Date(System.currentTimeMillis())) //Mandamos la fecha actual
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) //Seteamos el tiempo que tarda en caducar el token
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) //Seteamos el algoritmo de cifrado que es HS256
                .compact(); //Compactamos a un string
    }

    public String getUser(String token){ //Obtiene el nombre de usuario del token que mandamos
        return getClaim(token, Claims::getSubject); //Injectamos el metodo getSubject de la clase Claims
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) { //Utiliza la token para crear una nueva firma
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() { //Convierte la secretKey en base64
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token, UserDetails userDetails){ //Valida si el usuario que mandamos es igual al que obtiene del token
        // y tambien si el token no está expirado
        final String username = getUser(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){ // Valida si el token sigue activo
        return getExpiration(token).before(new Date());

    }

    private Date getExpiration(String token) { //Valida si el token no ha caducado con las propiedades internas de Claims
        return getClaim(token, Claims::getExpiration);
    }

}

