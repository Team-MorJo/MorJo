package com.morjo.controller;

import com.morjo.model.dto.KakaoTokenInfo;
import com.morjo.model.dto.User;
import com.morjo.model.service.UserSerivce;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.morjo.model.dto.KakaoToken;
import com.morjo.model.service.OAuthService;

import lombok.RequiredArgsConstructor;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final OAuthService oAuthService;
    private final UserSerivce userSerivce;

    @Value("${morjo.client-url}")
    private String CLIENT_URL;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String code, HttpSession session) {
        KakaoToken token = oAuthService.getKakaoToken(code);
        KakaoTokenInfo tokenInfo = oAuthService.getKakaoTokenInfo(token.getAccess_token());

        long userId = userSerivce.getUserByKakaoId(tokenInfo.getId());

        HttpHeaders headers = new HttpHeaders();

        if (userId > 0) {
            session.setAttribute("userId", userId);

            headers.setLocation(URI.create(CLIENT_URL));
            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).headers(headers).build();
        }

        session.setAttribute("kakaoId", tokenInfo.getId());

        headers.setLocation(URI.create(CLIENT_URL + "/join"));
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).headers(headers).build();
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user, HttpSession session) {
        Long kakaoId = (Long) session.getAttribute("kakaoId");

        if (kakaoId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("가입중인 유저가 아닙니다");
        }

        user.setKakaoId(kakaoId);
        boolean success = userSerivce.join(user);

        // !TODO 따로 에러를 줘야하는 상황 : 닉네임 중복
        if (success) {
            session.removeAttribute("kakaoId");
            session.setAttribute("userId", user.getUserId());
            ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 닉네임입니다");
    }
}
