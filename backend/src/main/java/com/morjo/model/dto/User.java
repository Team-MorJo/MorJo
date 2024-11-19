package com.morjo.model.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private Long userId;
	private Long kakaoId;
	private String ninkname;
	private String role;
	private Timestamp createdAt;
	
}
