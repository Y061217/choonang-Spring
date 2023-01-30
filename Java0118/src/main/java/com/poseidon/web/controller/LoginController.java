package com.poseidon.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poseidon.web.dto.JoinDTO;
import com.poseidon.web.dto.LoginDTO;
import com.poseidon.web.service.BoardService;
import com.poseidon.web.service.LoginService;

@Controller
public class LoginController {

	LoginDTO d = new LoginDTO();

	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login"; // webapp/WEB-INF/views/login.jsp
	}

	// (@RequestParam(name="id", required=false, defaultValue="user")
	@PostMapping("/login")
//                     (@RequestParam("mid") String id, @RequestParam("mpass") String pw, 필수값으로 지정
//	public String login(HttpServletRequest request) {
//		String id = request.getParameter("mid");
//		String pw = request.getParameter("mpass");
//		System.out.println(id);
//		System.out.println(pw);
//		
//		return "login";

	public String login(LoginDTO dto, HttpServletRequest request) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		// Controller -> Service -> DAO -> SqlSession - > DB

		LoginDTO result = loginService.login(dto);
		System.out.println("결과 :");
		System.out.print(result.getNo() + "\t");
		System.out.print(result.getName() + "\t");
		System.out.print(result.getAge() + "\t");
		System.out.print(result.getTel() + "\t");
		System.out.print(result.getEmail() + "\t");
		System.out.print(result.getCount() + "\t");

		if (result.getCount() == 0) {// 0 일치하지 않을 때
			return "redirect:/login?error=0010";
		} else if (result.getCount() == 1) {// 아이디 pw일치 시 = 정상 로그인
			// 세션만들기
			// HttpSession
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", result.getName());
			return "redirect:/board";
		}

		return "login";
	}

	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null) {
			session.removeAttribute("id");
		}
		
		if(session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		//일괄삭제
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}
	//post join = 회원가입정보를 다 입력하고 가입하기를 눌렀을 때
	/// check = 중복여부를 확인하는 메소드
	
	@PostMapping("/join")
	public String join(HttpServletRequest request) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw1");
		String email = request.getParameter("email");
		
		JoinDTO dto = new JoinDTO(name,id,pw,email);
		int result = loginService.join(dto);
		System.out.println(result);
		return "login";
	}
	
	@PostMapping("/checkID")
	@ResponseBody
	public String checkID(HttpServletRequest request) {
		System.out.println("아이디는"+request.getParameter("id"));
		String id = request.getParameter("id");
		id = loginService.checkID(id);
		return id;
	}
}
