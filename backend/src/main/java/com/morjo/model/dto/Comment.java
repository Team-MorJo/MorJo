package com.morjo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Comment {
    long commentId;
    long quizId;
    long userId;
    String content;
    Timestamp createdAt;
    boolean deleted;
}
