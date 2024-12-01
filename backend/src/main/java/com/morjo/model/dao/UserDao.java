package com.morjo.model.dao;

import java.util.List;

import com.morjo.model.dto.Quiz;
import com.morjo.model.dto.User;
import com.morjo.model.dto.UserScore;

public interface UserDao {
    User selectUserByKakaoId(Long kakaoId);
    User selectUserByUserId(Long userId);
    int insertUser(User user);
    UserScore selectUserScore(Long userId);
    List<Quiz> selectUserQuizSolved(Long userId);
    List<Quiz> selectUserQuizMade(Long userId);
}
