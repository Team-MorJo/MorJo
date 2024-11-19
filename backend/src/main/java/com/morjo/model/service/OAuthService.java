package com.morjo.model.service;

import com.morjo.model.dto.KakaoTokenInfo;
import com.morjo.util.OAuthUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.morjo.model.dto.KakaoToken;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthService {

	private final OAuthUtil oAuthUtil;

	public void login(String code) {
		KakaoToken token = oAuthUtil.getKakaoToken(code);
		KakaoTokenInfo tokenInfo = oAuthUtil.getKakaoTokenInfo(token.getAccess_token());
		Long kakaoId = tokenInfo.getId();

		// !TODO 유저id로 회원여부 판단해라
		// !TODO 회원아니라면 토큰 담아 보내서 닉네임 받아오고, 닉네임과 토큰 이용해서 등록해줘
		// !TODO 회원이라면 쿠키에 토큰 담아서 보내라
	}
}
