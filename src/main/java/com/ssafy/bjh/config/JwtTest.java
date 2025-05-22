package com.ssafy.bjh.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTest {
	public static void main(String[] args) throws InterruptedException {
		//비밀키가 필요해!
		String key = "봉준호는 절대 멈추지 않아";
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
		// 해시 알고리즘
		
		Map<String, String> headers = new HashMap<>();
		headers.put("typ", "JWT");
		
		String token = Jwts.builder() // Jwt를 만들 수 있는 빌더 객체
		.header() // 빌더 중에 헤더를 만드는 객체로 변경됨
		.add("name", "yu") // 연습용, 보통은 payload에 넣음.
		.add(headers).and() // 다시 JWT 빌더로 돌아왔다.
		.subject("jwt class")
		.expiration(new Date(System.currentTimeMillis()+3000)) // 현재시점 기준으로 3초만큼 유효하다.
		.signWith(secretKey) // 서명완료
		.compact();
		
		System.out.println(token);
		////////////////토큰 발급 했음
		
		Thread.sleep(4000);
		
		// 토큰 유효성 검증
		Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
		
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
	}
}
