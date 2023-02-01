package com.poseidon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.dto.PagingDTO;
import com.poseidon.web.dao.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public List<BoardDTO> list(PagingDTO paging) {

		return boardDAO.list(paging);
	}

	public BoardDTO detail(BoardDTO dto) {
		// 조회수 +1 기능
			boardDAO.read(dto);
		return boardDAO.detail(dto);
	}

	public int write(BoardDTO dto) {

		return boardDAO.write(dto);
	}

	public void delete(int no, String attribute) {
		BoardDTO dto = new BoardDTO();
		dto.setB_no(no);
		dto.setMember_id(attribute);
		boardDAO.delete(dto);

	}

	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.update(dto);
	}

	public void comment(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.comment(dto);
	}

	public List<BoardDTO> c_comment(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.c_comment(dto);
	}

	public int commentDel(BoardDTO comment) {
		return boardDAO.commentDel(comment);
		
	}

	public int upcmt(BoardDTO upcmt) {
		return boardDAO.upcmt(upcmt);
		
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return boardDAO.totalCount();
	}



}
