package com.poseidon.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.web.dto.NoticeDTO;
import com.poseidon.web.dto.PagingDTO;
import com.poseidon.web.service.NoticeService;
import com.poseidon.web.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeservice;

	@GetMapping("/notice")
	public String notice(Model n_val, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {		
		// 1. 전체 글의 갯수를 DB에 확인
		int totalRecordCount = noticeservice.totalCount();
		System.out.println("총 게시글 수" +totalRecordCount); // 2개 확인

		// 2. paginationInfo만들기
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalRecordCount);
		paginationInfo.setRecordCountPerPage(1);
		paginationInfo.setPageSize(2);
		paginationInfo.setCurrentPageNo(pageNo);
		// 계산
		int startPage = paginationInfo.getFirstRecordIndex();
		int lastPage = paginationInfo.getRecordCountPerPage();
		// DB로 보낼 값
		PagingDTO paging = new PagingDTO(startPage, lastPage);
		
		n_val.addAttribute("n_val", noticeservice.list(paging));
		n_val.addAttribute("paginationInfo" , paginationInfo);
		n_val.addAttribute("pageNo", pageNo);
		System.out.println(n_val);
		return "notice";
	}

	@GetMapping("/n_detail")
	public String notice(HttpServletRequest request, Model n_detail) {
		int no = Util.str2Int(request.getParameter("no"));
		n_detail.addAttribute("n_val", noticeservice.detail(no));
		return "n_detail";
	}
	
	@GetMapping("/n_write")
	public String n_write(HttpSession session) {
		
		return "n_write";
	}
	
	@PostMapping("/n_write")
	public String n_write(HttpServletRequest request , HttpSession session) {
		String n_title = request.getParameter("title");
		String n_content = request.getParameter("content");
		String admin_name = (String) session.getAttribute("name");
		NoticeDTO noticedto = new NoticeDTO();
		noticedto.setN_title(n_title);
		noticedto.setN_content(n_content);
		noticedto.setAdmin_name(admin_name);
			
		noticeservice.n_write(noticedto);
		
		
		return "redirect:/notice";
	}
}
