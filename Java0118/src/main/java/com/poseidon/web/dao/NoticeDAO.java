package com.poseidon.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.web.dto.NoticeDTO;
import com.poseidon.web.dto.PagingDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<NoticeDTO> list(PagingDTO paging) {
		
		return sqlSession.selectList("notice.list" , paging);
	}

	public NoticeDTO detail(int no) {
			sqlSession.update("notice.readup" , no);
		return sqlSession.selectOne("notice.detail" , no);
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.totalCount");
	}
	
	
	
}
