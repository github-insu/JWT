package com.example.JWT.common.support;

import com.example.JWT.common.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public final class JwtProvider {

    private final Key secretKey;
    private final Long maxAge;


    public JwtProvider(JwtProperties jwtProperties) {
        this.secretKey = jwtProperties.secretKey();
        this.maxAge = jwtProperties.maxAge();
    }

    public String generateJwt(String subject, Map<? extends String, ?> payload) {

        Claims claims = Jwts.claims()
                .setSubject(subject);

        Date now = new Date();
        Date expirationAt = new Date(now.getTime() + 1_800L);

        claims.putAll(payload);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expirationAt)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
}
