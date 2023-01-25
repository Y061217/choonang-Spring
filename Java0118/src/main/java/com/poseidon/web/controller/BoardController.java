package com.poseidon.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.web.dto.BoardDTO;
import com.poseidon.web.service.BoardService;

/*
 * 클래스 선언 위에 작성
 * @Controller : 객체 생성 + 컨트롤러 역할
 * @Service : 객체 생성 + 서비스 역할
 * @Repository : 객체 생성 + DAO 역할
 * @Componet : 객체 생성 + 그 외 역할 
 */

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public ModelAndView board() {
		ModelAndView mv = new ModelAndView("board");
		// db에서 게시판 읽어오기
		// Controller -> Service -> DAO -> Maybatis -> DB

		List<BoardDTO> board = boardService.list();
		// jsp에 전달
		mv.addObject("board", board); // 사용할 이름, 값

		return mv;
	}

	@GetMapping("/detail")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("detail");
		String bno = request.getParameter("b_no"); // url에서 ?b_no 뒤에 있는 데이터 추출
		BoardDTO dto = new BoardDTO();
		dto.setB_no(Integer.parseInt(bno));

		dto = boardService.detail(dto);
		mv.addObject("detail", dto);
		return mv;
	}

	@GetMapping("/write")
	public String write(HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "write";
		} else {
			return "redirect:/login?login=4569";
		}
	}

	@PostMapping("/write")
	public String write(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content, HttpSession session) {
		System.out.println(title);
		System.out.println(content);

		BoardDTO dto = new BoardDTO();
		dto.setB_title(title);
		dto.setB_content(content);
		dto.setB_write((String) session.getAttribute("name"));

		int result = boardService.write(dto);
		System.out.println("결과 : " + result);

		return "redirect:/board"; // board를 진행하고
	}
}
