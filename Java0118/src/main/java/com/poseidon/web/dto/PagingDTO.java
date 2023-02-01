package com.poseidon.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //생성자 조건을 대신 만들어주는 어노테이션
public class PagingDTO {
	private int startPage , lastPage;
}
