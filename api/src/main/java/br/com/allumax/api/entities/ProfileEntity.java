package br.com.allumax.api.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class ProfileEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String fullname;
  private String bio;
  private String phone;
  @Column(name = "create_at")
  private Date createAt;
  @Column(name = "update_at")
  private Date updateAt;
  @Column(name = "delete_at")
  private Date deleteAt;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  public ProfileEntity() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public Date getDeleteAt() {
    return deleteAt;
  }

  public void setDeleteAt(Date deleteAt) {
    this.deleteAt = deleteAt;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
    result = prime * result + ((bio == null) ? 0 : bio.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
    result = prime * result + ((updateAt == null) ? 0 : updateAt.hashCode());
    result = prime * result + ((deleteAt == null) ? 0 : deleteAt.hashCode());
    result = prime * result + ((user == null) ? 0 : user.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProfileEntity other = (ProfileEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (fullname == null) {
      if (other.fullname != null)
        return false;
    } else if (!fullname.equals(other.fullname))
      return false;
    if (bio == null) {
      if (other.bio != null)
        return false;
    } else if (!bio.equals(other.bio))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (createAt == null) {
      if (other.createAt != null)
        return false;
    } else if (!createAt.equals(other.createAt))
      return false;
    if (updateAt == null) {
      if (other.updateAt != null)
        return false;
    } else if (!updateAt.equals(other.updateAt))
      return false;
    if (deleteAt == null) {
      if (other.deleteAt != null)
        return false;
    } else if (!deleteAt.equals(other.deleteAt))
      return false;
    if (user == null) {
      if (other.user != null)
        return false;
    } else if (!user.equals(other.user))
      return false;
    return true;
  }

}
