package com.codegym.vn.services;

import com.codegym.vn.models.auth_security.AccountPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component

public class JwtService {

    private static final String SECRECT_KEY  = "whoarewho";
    private static final long EXPIRE_TIME = 10000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class.getName());

    public String generateTokenLogin(Authentication authentication) {
        AccountPrinciple accountPrinciple = (AccountPrinciple)authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(accountPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+ EXPIRE_TIME*24*60*60*1000))
                .signWith(SignatureAlgorithm.HS512,SECRECT_KEY)
                .compact();

    }
    public boolean validateJwtToken(String authToken) {
        try {
         Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(authToken);
         return true;
        } catch (SignatureException e){
            logger.error("Invalid JWT signature -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message:{}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        return false;
    }
    public String getUserNameFromJwtToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(SECRECT_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return username;
    }

}
