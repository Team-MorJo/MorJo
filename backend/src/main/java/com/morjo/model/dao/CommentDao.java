package com.morjo.model.dao;

import com.morjo.model.dto.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectCommentsByQuizId(long quizId);
}
