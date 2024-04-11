package br.com.allumax.api.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;

import br.com.allumax.api.entities.UserEntity;

@Service
public class TokenService {

  @Value("${security.token.secret}")
  private String secret = "${r>KPxk@`O(af;aCYr6Q1Q8pXK!M5{#}";
  @Value("${security.token.issuer}")
  private String issuer;
  private Algorithm algorithm = Algorithm.HMAC256(secret);
  
  public String generateToken(UserEntity userEntity) {
    try {
      String token = JWT.create()
        .withIssuer(issuer)
        .withSubject(userEntity.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);

      return token;
    } catch (JWTCreationException ex) {
      throw new RuntimeException("Error to generate token: " + ex.getMessage());
    }
  }

  public String validateToken(String token) {
    try {
      JWT.require(algorithm)
        .withIssuer(issuer)
        .build()
        .verify(token);

      return JWT.decode(token).getSubject();
    } catch (JWTDecodeException ex) {
      throw new RuntimeException("Error to validate token: " + ex.getMessage());
    }
  }

  public String parseToken(String header) {
    if (header == null || !header.startsWith("Bearer "))
      return null;
    else
    return header.replace("Bearer ", "");
  } 

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
