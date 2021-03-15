package com.psybergate.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(unique = true)
    private String email;

    private String password;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Collection<UserRole> roles;

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
