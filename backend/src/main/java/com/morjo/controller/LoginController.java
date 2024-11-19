package com.morjo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.morjo.model.dto.KakaoToken;
import com.morjo.model.service.OAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final OAuthService oAuthService;

	@Value("${kakao.rest-api-key}")
	String key;

	@GetMapping("/login")
	// code는 요청 쿼리파라미터에서 받아온 인가코드
	public ResponseEntity<?> login(@RequestParam String code) {

		oAuthService.login(code);

		// 리다이렉트 url을 전송해줘
		return ResponseEntity.ok("whatever");
	}
}
