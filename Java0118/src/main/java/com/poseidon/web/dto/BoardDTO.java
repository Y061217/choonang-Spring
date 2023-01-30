package com.poseidon.web.dto;

import lombok.Data;


@Data
public class BoardDTO {
	private int b_no , b_like, b_read, comment , member_no;
	private String listdate , c_comment, member_id, b_title, b_content, b_write, b_date, member_name ,  c_date;
	
}
