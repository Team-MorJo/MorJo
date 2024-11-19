package com.morjo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTokenRequest {

	private String grant_type;
	private String client_id;
	private String redirect_uri;
	private String code;
	
}
