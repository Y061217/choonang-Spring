package com.poseidon.web.dto;

import lombok.Data;


@Data
public class JoinDTO {
	private String name , id, pw,email;
	
	public JoinDTO(String name, String id, String pw, String email) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}
	
}
