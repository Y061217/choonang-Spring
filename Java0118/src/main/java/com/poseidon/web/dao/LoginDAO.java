package com.poseidon.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.web.dto.JoinDTO;
import com.poseidon.web.dto.LoginDTO;

@Repository
public class LoginDAO {
	
	
	@Autowired
	private SqlSession sqlSession;

	public LoginDTO login(LoginDTO dto) {
		
		return sqlSession.selectOne("login.login", dto);
	}

	public int join(JoinDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("login.join", dto);
	}

	public String checkID(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("login.checkID", id);
	}
	
	
}
