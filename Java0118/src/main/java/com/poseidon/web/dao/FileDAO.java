package com.poseidon.web.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.web.MemberDTO;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<MemberDTO> memberList() {
		return sqlSession.selectList("member.list");
	}
	
	
}
