package com.poseidon.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.web.service.DrawService;

@Controller
public class DrawController {
	// DB를 연동하지 않고 스스로 처리
	 @Autowired
	//@Resource(name = "drawService")
	private DrawService drawService;

	@GetMapping("/draw")
	public String draw() {
		// 페이지만 열어주면됨
		// Data까지 같이 붙여서 보여줄거면 -> ModelAndView

		return "draw"; // jsp file name
	}

	@PostMapping("/draw")
	public ModelAndView draw(HttpServletRequest requset) {
		ModelAndView mv = new ModelAndView("draw");

		String names = requset.getParameter("names");

		List<String> result = drawService.result(names);
		System.out.println("뽑기 전" + result);
		String speaker = result.get(0);
		result.remove(0);
		System.out.println(result);
		String code = result.get(0);

		mv.addObject("speaker", speaker);
		mv.addObject("code", code);

		return mv;
	}
}
