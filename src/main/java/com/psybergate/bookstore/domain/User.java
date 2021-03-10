package com.psybergate.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User extends BaseEntity{

    @Column(unique = true)
    private String email;

    private String password;

    @Override
    public boolean equals(Object o) {
      if(o == null) return false;
      if(this.getClass() != o.getClass()) return false;
      User user = (User) o;
      return user.getEmail().equals(this.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
