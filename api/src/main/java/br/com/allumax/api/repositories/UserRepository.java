package br.com.allumax.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.allumax.api.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

  @Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.enable = true")
  Optional<UserDetails> findByUsername(@Param("username") String username);
}
