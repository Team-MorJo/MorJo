package com.morjo.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	@Value("${jwt.secret-key}")
	private String key;
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	public String createToken(Long userId) {
		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 30);
		return Jwts.builder().header().add("typ", "JWT").and()
				.claim("userId", userId).expiration(exp)
				.signWith(secretKey).compact();
	}
	
	public Jws<Claims> validate(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
	
}
