package com.example.util;

import java.util.Date;

import javax.crypto.SecretKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Component;


@Component
public class JwtUtili {

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Generate a JWT token for a given username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60*10  )) // 10 mins expiration
                .signWith(key, SignatureAlgorithm.HS256) // New syntax for signing
                .compact();
    }

    // Extract username from the token
    public String extractUserName(String token) {
        return getClaims(token).getSubject();
    }

    // Validate the token by checking username and expiration
    public Boolean validateToken(String token, String username) {
        return (username.equals(extractUserName(token)) && !isTokenExpired(token));
    }

    // Check if the token is expired
    private Boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Utility method to get claims from the token
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // New syntax for setting signing key
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}