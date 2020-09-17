package com.codegym.vn.configuration.filter;

import com.codegym.vn.services.JwtService;
import com.codegym.vn.services.userServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class  JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
          String jwt = getJwtFromRequest(request);
          if (jwt != null && jwtService.validateJwtToken(jwt)) {
              String username =jwtService.getUserNameFromJwtToken(jwt);

              UserDetails userDetails = userService.
          }

        }catch (Exception e ){
            logger.error("Can not set user authentication -> Message: {}", e);
        }

    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader !=null && authHeader.startsWith("Bearer")) {
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }
}
