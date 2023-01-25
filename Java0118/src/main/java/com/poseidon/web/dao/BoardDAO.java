package com.poseidon.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.web.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	//연결방법
	//autowired : type으로 검색해서 저장, Spring 기본 제공
	//inject : type으로 검색해서 저장, Java 기본 제공
	//Resource : name으로 검색해서 저장, Java 제공
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> list() {
		
		return sqlSession.selectList("board.list");//네임스페이스.아이디
	}

	public BoardDTO detail(BoardDTO dto) {
		
		return sqlSession.selectOne("board.detail", dto);
	}

	public int write(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.write", dto);
	}
	
}
