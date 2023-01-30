package com.poseidon.web.dto;

import lombok.Data;


@Data
public class LoginDTO { //form name 값과 DTO에서의 변수명은 서로 같아야 정상적으로 작동한다.
	private int count,age,no;
	
	private String id, pw, name, tel, email;
}
