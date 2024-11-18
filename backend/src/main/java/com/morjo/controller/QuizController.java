package com.morjo.controller;

import com.morjo.model.dto.Quiz;
import com.morjo.model.dto.QuizResult;
import com.morjo.model.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/{quizId}")
    public ResponseEntity<?> findSpecificQuiz(@PathVariable("quizId") int quizId) {
        Quiz quiz = quizService.findQuizById(quizId);

        if (quiz == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 번호의 퀴즈를 찾을 수 없습니다");
        }

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @GetMapping("/{quizId}/result")
    public ResponseEntity<?> getQuizResult(@PathVariable("quizId") int quizId) {
        QuizResult result = quizService.getQuizResultById(quizId);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 번호의 퀴즈를 찾을 수 없습니다");
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}