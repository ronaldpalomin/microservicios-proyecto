package com.authservice.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.security.Key;

@Component
public class JwtUtil {

    private static final String CLAVE = "ac76aaf0c16ffe73e7fde95baccf1e7f";
    private static final long EXPIRACION = 1000 * 60 * 60; // 1 hora

    private Key getClave() {
        return Keys.hmacShaKeyFor(CLAVE.getBytes());
    }

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRACION))
                .signWith(getClave(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsuario(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getClave())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getClave())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            System.out.println("Token inválido: " + e.getMessage());
            return false;
        }
    }
}
