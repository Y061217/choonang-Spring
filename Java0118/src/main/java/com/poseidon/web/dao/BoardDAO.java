package com.poseidon.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.dto.PagingDTO;

@Repository
public class BoardDAO {
	
	//연결방법
	//autowired : type으로 검색해서 저장, Spring 기본 제공
	//inject : type으로 검색해서 저장, Java 기본 제공
	//Resource : name으로 검색해서 저장, Java 제공
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> list(PagingDTO paging) {
		
		return sqlSession.selectList("board.list" , paging);//네임스페이스.아이디
	}

	public BoardDTO detail(BoardDTO dto) {
		
		return sqlSession.selectOne("board.detail", dto);
	}

	public int write(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.write", dto);
	}

	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.delete("board.delete" , dto);
		
	}

	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("board.update", dto);
	}

	public void read(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("board.read", dto);
	}

	public void comment(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("board.comment", dto);
	}

	public List<BoardDTO> c_comment(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.c_comment", dto);
	}

	public int commentDel(BoardDTO comment) {
		return sqlSession.update("board.commentdel", comment);
		
	}

	public int upcmt(BoardDTO upcmt) {
		return sqlSession.update("board.upcmt", upcmt);
		
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.totalCount");
	}
	
	


}
