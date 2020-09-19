package com.codegym.vn.controllers;

import com.codegym.vn.models.auth_security.JwtResponse;
import com.codegym.vn.models.user.User;
import com.codegym.vn.services.JwtService;
import com.codegym.vn.services.userServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auths")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        User currentUser = userService.findUserByUsername(user.getUsername()).get();
        return  ResponseEntity.ok(new JwtResponse(jwt,currentUser.getId(),userDetails.getUsername(),
                currentUser.getFirstName(), currentUser.getLastName(),userDetails.getAuthorities()));
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> isExistUser = userService.findUserByUsername(user.getUsername());
        if (isExistUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User saveUser = userService.save(user);
            return new ResponseEntity<>(saveUser, HttpStatus.OK);
        }
    }
    @GetMapping()
    public ResponseEntity<List<User>> listUsers() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }


}

