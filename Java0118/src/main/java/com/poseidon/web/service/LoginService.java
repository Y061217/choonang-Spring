package com.poseidon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dao.LoginDAO;
import com.poseidon.web.dto.JoinDTO;
import com.poseidon.web.dto.LoginDTO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	public LoginDTO login(LoginDTO dto) {
		
		return loginDAO.login(dto);
	}

	public int join(JoinDTO dto) {
		
		return loginDAO.join(dto);
	}

	public String checkID(String id) {
		// TODO Auto-generated method stub
		return loginDAO.checkID(id);
	}

}
