package br.com.allumax.api.entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String usernama;
  private String password;
  @Column(name = "account_non_expired")
  private Boolean accountNonExpired;
  @Column(name = "account_non_locked")
  private Boolean accountNonLocked;
  @Column(name = "credentials_non_expired")
  private Boolean credentialsNonExpired;
  private Boolean enable;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_permissions",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id")
  )
  private Collection<PermissionEntity> permissions;
}
