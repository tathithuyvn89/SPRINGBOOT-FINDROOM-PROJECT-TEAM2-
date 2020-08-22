package com.codegym.vn.models;

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
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String avatar;

    @ManyToMany
  private Set<Role> roles;
}