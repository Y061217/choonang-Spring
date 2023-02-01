package com.poseidon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dao.NoticeDAO;
import com.poseidon.web.dto.NoticeDTO;
import com.poseidon.web.dto.PagingDTO;

@Service
public class NoticeService {
	@Autowired
	public NoticeDAO noticedao;

	public List<NoticeDTO> list(PagingDTO paging) {
		
		return noticedao.list(paging);
	}

	public NoticeDTO detail(int no) {
		// TODO Auto-generated method stub
		return noticedao.detail(no);
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return noticedao.totalCount();
	}
	
	
}
