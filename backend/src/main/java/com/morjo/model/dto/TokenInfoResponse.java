package com.morjo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfoResponse {

	private Long id;
	private Integer expires_in;
	private Integer app_id;
	
}
