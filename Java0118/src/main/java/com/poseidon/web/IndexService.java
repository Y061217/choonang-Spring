package com.poseidon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IndexService {
	@Autowired
	private IndexDAO indexDAO;

	public List<MemberDTO> list() {
		
		return indexDAO.list();
	}
	
	
	//service -> DAO(database active operator)
}
