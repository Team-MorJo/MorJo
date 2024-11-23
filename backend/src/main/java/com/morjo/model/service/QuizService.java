package com.morjo.model.service;

import com.morjo.model.dao.QuizDao;
import com.morjo.model.dto.Quiz;
import com.morjo.model.dto.QuizResult;
import com.morjo.model.dto.QuizSubmit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizDao quizDao;

    public Quiz getQuizRandom(long userId) {
        return quizDao.selectQuizRandom(userId);
    }

    public Quiz getQuizById(long quizId) {
        return quizDao.selectQuizById(quizId);
    }

    public QuizResult getQuizResultById(long quizId) {
        Quiz quiz = quizDao.selectQuizById(quizId);

        if (quiz == null) {
            return null;
        }

        return quizDao.selectQuizResultById(quizId);
    }

    public long createQuiz(Quiz quiz) {
        if (quiz.getContent() == null || quiz.getAnswer() == 0 || quiz.getOption1() == null
                || quiz.getOption2() == null) {
            return -1;
        }

        if (quiz.getOption3() == null && quiz.getOption4() != null) {
            return -1;
        }

        quizDao.insertQuiz(quiz);

        return quiz.getQuizId();
    }
    
    public int submitQuizResult(QuizSubmit quizSubmit) {
        if (quizSubmit.getUserAnswer() == 0) {
            return -1;
        }
        
        return quizDao.insertQuizSubmit(quizSubmit);
    }
}
