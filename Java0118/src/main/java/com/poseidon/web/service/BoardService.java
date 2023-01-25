package com.poseidon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.dao.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> list() {
		
		return boardDAO.list();
	}

	public BoardDTO detail(BoardDTO dto) {
		
		return boardDAO.detail(dto);
	}

	public int write(BoardDTO dto) {
		
		return boardDAO.write(dto);
	}

	
}
