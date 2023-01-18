package com.poseidon.web;
//MVC 중 C

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public ModelAndView member() {
		ModelAndView mv = new ModelAndView("member"); //데이터 값을 넘기기 위해 사용
		//Controller -> Service -> DAO -> Mybatis -> DB
		List<MemberDTO> list = indexService.list();
		mv.addObject("list", list); // key value
		return mv;
	}
	
	@Autowired
	private IndexService indexService;
	
	
	
	
}
