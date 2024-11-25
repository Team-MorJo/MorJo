package com.morjo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.morjo.model.dao.UserDao;
import com.morjo.model.dto.Quiz;
import com.morjo.model.dto.User;
import com.morjo.model.dto.UserScore;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;
    
    public boolean checkUser(Long userId) {
        User user = userDao.selectUserByUserId(userId);
        
        return user != null;
    }
    
    public boolean join(User user) {
        // !TODO nickname 유효성 검사
        // !TODO 다양한 예외 상황들을 어떻게 http 응답에 보낼까
        return userDao.insertUser(user) == 1;
    }

    public long getUserByKakaoId(Long kakaoId) {
        User user = userDao.selectUserByKakaoId(kakaoId);

        if (user == null) {
            return -1;
        }

        return user.getUserId();
    }
    
    public UserScore getUserScore(Long userId) {
        return userDao.selectUserScore(userId);
    }

    public List<Quiz> getUserQuizSolved(Long userId) {
        return userDao.selectUserQuizSolved(userId);
    }
    
    public List<Quiz> getUserQuizMade(Long userId) {
        return userDao.selectUserQuizMade(userId);
    }
}
