package com.poseidon.web;

import java.util.Date;

import lombok.Data;
@Data
//나중에 롬복이 오면 달라져요
public class MemberDTO {
	private int member_no, member_age;
	private String member_name , member_tel , member_email, member_id, member_pw;

	
	
}
