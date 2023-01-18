package com.poseidon.web;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//value뒤에 메소드를 적습니다. 제외하면 get/post 모두를 서비스 합니다.
	@RequestMapping(value = "/index")
	public String index() {// "/"요청이 들어오면 동작할 메소드
		return "index"; //jsp file name
		
	}
	//@RequestMapping("/main")
	@GetMapping("/main")
	public String main() {
		return "main";  
	}
	
	@PostMapping("/email")
	public ModelAndView email(HttpServletRequest request) {
		System.out.println("입력하신 이메일은 : " + request.getParameter("email"));
		
		ModelAndView mv = new ModelAndView("email"); // jsp file name
		//jsp파일을 열 때 해당 값을 붙일 수 있도록 값 보내기
		mv.addObject("email", request.getParameter("email"));
		return mv;
	}
	//형상관리프로그램 메이븐 maven
}
