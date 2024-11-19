package com.morjo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTokenResponse {

	private String access_token;
	private Integer expires_in;
	private String refresh_token;
	private Integer refresh_token_expires_in;
	
}
