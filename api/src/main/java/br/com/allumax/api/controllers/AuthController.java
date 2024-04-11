package br.com.allumax.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.allumax.api.entities.UserEntity;
import br.com.allumax.api.records.AuthRecord;
import br.com.allumax.api.services.TokenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody UserEntity userEntity) {
    try {
      var data = new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword());
      var authenticated = authenticationManager.authenticate(data);
      var token = tokenService.generateToken((UserEntity) authenticated.getPrincipal());

      AuthRecord authRecord = new AuthRecord(
          ((UserEntity) authenticated.getPrincipal()).getId(),
          ((UserEntity) authenticated.getPrincipal()).getUsername(),
          authenticated.getAuthorities(),
          token);

      return ResponseEntity.ok(authRecord);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
