package com.morjo.model.dao;

import java.util.Optional;

import com.morjo.model.dto.User;

public interface UserDao {
	void insertUser(User user);
	
	Optional<User> selectOne(long kakaoId);
}
