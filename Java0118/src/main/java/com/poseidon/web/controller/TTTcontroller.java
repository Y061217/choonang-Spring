package com.poseidon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TTTcontroller {
	
	@GetMapping("/ttt")
	public ModelAndView ttt() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
