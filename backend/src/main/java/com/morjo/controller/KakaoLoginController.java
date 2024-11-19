package com.morjo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morjo.model.dto.GetTokenResponse;
import com.morjo.model.dto.TokenInfoResponse;
import com.morjo.model.service.OAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class KakaoLoginController {
	
	private final OAuthService oAuthService;

	@PostMapping("/kakao/token")
	public ResponseEntity<GetTokenResponse> GetToken(@RequestBody Map<String, String> request) {
		String code = request.get("code");
		GetTokenResponse tokenResponse = oAuthService.getToken(code);
		String accessToken = tokenResponse.getAccess_token();
		TokenInfoResponse tokenInfoResponse = oAuthService.getTokenInfo(accessToken);
		System.out.println(tokenInfoResponse.getId());
		return ResponseEntity.ok(tokenResponse);
	}
	
}
