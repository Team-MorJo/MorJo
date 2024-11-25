package com.morjo.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQuiz {
    List<Quiz> quizzes;
}
