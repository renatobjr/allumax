package br.com.allumax.api.configs;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.allumax.api.repositories.UserRepository;
import br.com.allumax.api.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTokenValidationConfig extends OncePerRequestFilter {

  @Autowired
  TokenService tokenService;

  @Autowired
  UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var token = tokenService.parseToken(request.getHeader("Authorization"));

    try {
      if (token != null) {
        String username = tokenService.validateToken(token);
        Optional<UserDetails> loggedUser = userRepository.findByUsername(username);

        if (loggedUser.isPresent()) {
          var isAuth = new UsernamePasswordAuthenticationToken(username, null, loggedUser.get().getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(isAuth);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    filterChain.doFilter(request, response);
  }

}
