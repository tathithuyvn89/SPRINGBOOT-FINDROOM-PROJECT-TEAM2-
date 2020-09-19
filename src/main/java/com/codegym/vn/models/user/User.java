package com.codegym.vn.models.user;

import com.codegym.vn.models.user.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
  public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String personId;
    private String address;
    private String email;
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
  private Set<Role> roles;
}