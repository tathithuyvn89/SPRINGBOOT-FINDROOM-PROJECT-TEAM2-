package com.codegym.vn.models.auth_security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtResponse {
  private Long id;
  private String token;
  private String type = "Bearer";
  private String userName;
  private String firstName;
  private String lastName;
  private Collection<? extends GrantedAuthority> roles;

    public JwtResponse( String accessToken,Long id, String userName, String firstName,
                       String lastName, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = accessToken;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
