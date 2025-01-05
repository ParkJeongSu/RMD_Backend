package com.jspark.rdmbackend.Util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "mySecretKeyForJwtToken1234567890";
    private static final Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1시간 유효
                .signWith(secretKey, SignatureAlgorithm.HS256)  // 최신 방식
                .compact();
    }

    public static Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)  // 서명에 사용된 키로 검증
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("토큰이 만료됨");
        } catch (MalformedJwtException e) {
            System.out.println("토큰 형식이 올바르지 않음");
        }
        return false;
    }
}
