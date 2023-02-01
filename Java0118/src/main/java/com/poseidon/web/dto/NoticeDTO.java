package com.poseidon.web.dto;

import lombok.Data;

@Data
public class NoticeDTO {
	private int n_no , admin_no , n_read , n_like;
	private String n_title , n_content , admin_name , n_date;
}
