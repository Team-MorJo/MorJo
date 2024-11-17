package com.morjo.model.service;

import com.morjo.model.dao.QuizDao;
import com.morjo.model.dto.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizDao quizDao;

    public Quiz findQuizById(long quizId) {
        return quizDao.selectQuizById(quizId);
    }
}
