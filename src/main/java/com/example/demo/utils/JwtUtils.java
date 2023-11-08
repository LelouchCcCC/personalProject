package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {
    private static final String secret = "www.github.com/LelouchCcCC|www.github.com/LelouchCcCC|www.github.com/LelouchCcCC";
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String generateToken(String username){
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(secret.getBytes());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());

        Date now = new Date();
        long expire = 604800;
        Date expiration = new Date(now.getTime() + 1000* expire);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .subject(username)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(signingKey,SignatureAlgorithm.HS512) // Use the signWith method with Key instance
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        // Convert your string key to a SecretKey object
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(secret.getBytes());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());

        // Parse the token
        Claims claims = Jwts.parser()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Return the subject (username)
        return claims.getSubject();
    }

}
