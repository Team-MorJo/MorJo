package com.morjo.model.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.morjo.model.dto.GetTokenResponse;
import com.morjo.model.dto.TokenInfoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthService {

	@Value("${kakao.client-id}")
	private String kakaoClientId;

	@Value("${kakao.redirect-uri}")
	private String kakaoRedirectUri;

	public GetTokenResponse getToken(String code) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=utf-8"));

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", kakaoClientId);
		body.add("redirect_uri", kakaoRedirectUri);
		body.add("code", code);

		HttpEntity<Object> entity = new HttpEntity<Object>(body, headers);

		GetTokenResponse response = restTemplate.postForEntity("https://kauth.kakao.com/oauth/token", entity, GetTokenResponse.class).getBody();

		return response;
	}

	public TokenInfoResponse getTokenInfo(String accessToken) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<TokenInfoResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/user/access_token_info", HttpMethod.GET, entity, TokenInfoResponse.class);
		return response.getBody();

	}

}
