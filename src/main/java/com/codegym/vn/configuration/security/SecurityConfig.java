package com.codegym.vn.configuration.security;

import com.codegym.vn.configuration.custom.CustomAccessDeniedHandler;
import com.codegym.vn.configuration.custom.RestAuthenticationEntryPoint;
import com.codegym.vn.models.auth_security.RoleName;
import com.codegym.vn.models.user.Role;
import com.codegym.vn.models.user.User;
import com.codegym.vn.services.roleServiceImpl.RoleService;
import com.codegym.vn.services.userServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

   @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
       return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
   @PostConstruct
    public void init() {
       List<User> users = userService.findAll();
       List<Role> rolesList = roleService.findAll();
       // Setup database for role table
       if (rolesList.isEmpty()) {
           Role roleAdmin = new Role();
           roleAdmin.setId(1L);
           roleAdmin.setName(RoleName.ROLE_ADMIN.toString());
           roleService.save(roleAdmin);

           Role roleUser = new Role();
           roleUser.setId(2L);
           roleUser.setName(RoleName.ROLE_USER.toString());
           roleService.save(roleUser);
       }


       // Setup database for user table

       if (users.isEmpty()) {
           User admin = new User();
           Set<Role> roles = new HashSet<>();
           roles.add(roleService.findRoleByName(RoleName.ROLE_ADMIN.toString()));
           roles.add(roleService.findRoleByName(RoleName.ROLE_USER.toString()));
           admin.setRoles(roles);
           admin.setId(1L);
           admin.setFirstName("Thuy");
           admin.setLastName("Ta Thi");
           admin.setUsername("admin");
           admin.setPassword("12345");
           userService.save(admin);
       }

   }
  @Autowired
  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception  {
       auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

}
