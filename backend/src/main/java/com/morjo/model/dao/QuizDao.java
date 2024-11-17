package com.morjo.model.dao;

import com.morjo.model.dto.Quiz;

public interface QuizDao {
    Quiz selectQuizById(long quizId);
}
