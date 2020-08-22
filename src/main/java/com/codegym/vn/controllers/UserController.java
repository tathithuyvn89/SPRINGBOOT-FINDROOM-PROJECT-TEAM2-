package com.codegym.vn.controllers;

import com.codegym.vn.models.JwtResponse;
import com.codegym.vn.models.Role;
import com.codegym.vn.models.User;
import com.codegym.vn.services.JwtService;
import com.codegym.vn.services.customerServiceImpl.UserService;
import com.codegym.vn.services.roleServiceImpl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("api/customers")
  public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private RoleService roleService;


  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User user){
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtService.generateTokenLogin(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    User currentUser = userService.findByUsername(user.getUsername());
    return ResponseEntity.ok(new JwtResponse(jwt,currentUser.getId(),userDetails.getUsername(),userDetails.getAuthorities()));
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user){
    Set<Role> roles = new HashSet<>();
    user.setAvatar("https://ramenparados.com/wp-content/uploads/2019/03/no-avatar-png-8.png");
    List<User> userList = userService.findAll();
    for (User u : userList){
      if (u.getUsername().equals(user.getUsername())){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
    Role role =roleService.findByName("ROLE_USER");
    roles.add(role);
    user.setRoles(roles);
    String password = user.getPassword();
    String encoderPassword = new BCryptPasswordEncoder().encode(password);
    user.setPassword(encoderPassword);
    userService.save(user);
    return new ResponseEntity<>(user,HttpStatus.OK);
  }
}