package com.poseidon.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDAO {
	
	//자동연결기술 sqlSession을 자동으로 객체화(new 를 통한 생성이 아님)
	@Autowired
	private SqlSession sqlSession;

	public List<MemberDTO> list() {
		
		return sqlSession.selectList("member.list");//네임스페이스.id 한줄 불러옴
	}
	
	
	// controller -> service -> DAO -> Mybatis -> DB
}
