package com.morjo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTokenRequest {

	private String grant_type;
	private String client_id;
	private String redirect_uri;
	private String code;
	
}