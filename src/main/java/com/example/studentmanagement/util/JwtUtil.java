package com.example.studentmanagement.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtUtil {

    private final String SECRET_KEY = "CL4loYvrbmPO6W8wf87q4S+7TttZKBCL6mYWQo4gVOA=";

    public String generateToken(String email) {
        return Jwts.builder()
                //.setClaims(extraClaims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(
                        Date.from(
                                LocalDateTime.now().plusYears(1).toLocalDate()
                                        .atStartOfDay(ZoneId.systemDefault())
                                        .toInstant()
                        )
                )
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenValid(String token) {
        return true;
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getEmailFromToken(String token) {
        var claims = Jwts.parser().setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("email", String.class);
    }
}

