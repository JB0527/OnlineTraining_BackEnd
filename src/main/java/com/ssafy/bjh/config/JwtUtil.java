package com.ssafy.bjh.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.ssafy.bjh.model.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "봉준호는 절대 멈추지 않아";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	// 토큰 생성 시 다양한 데이터를 저장할 수 있음 (DTO or Map)
	public String createToken(User user) {
		// 유효기간
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", user.getId());
		claims.put("name", user.getName());
		claims.put("isSubscribed", user.isSubscribed());

		Date exp = new Date(System.currentTimeMillis()+1000*60*60);
		return Jwts.builder().header().add("typ", "JWT").and()
				.claims(claims).expiration(exp)
				.signWith(secretKey).compact();
	}
	
	// 유효성 검증 (실제로 내용들을 확인하기 위함은 아님 / 에러나면 유효기간 지난 것
	// 이거 실행했을 때 에러나면 유효기간 지난 거...
	
	public Jws<Claims> vailidate(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
}
