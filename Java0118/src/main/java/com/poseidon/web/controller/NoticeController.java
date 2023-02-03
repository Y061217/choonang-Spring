package com.poseidon.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.web.dto.NoticeDTO;
import com.poseidon.web.dto.PagingDTO;
import com.poseidon.web.service.NoticeService;
import com.poseidon.web.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {
	@Autowired
	private ServletContext context;
	
	@Autowired
	NoticeService noticeservice;
	
	@Autowired
	Util util;


	@GetMapping("/notice")
	public String notice(Model n_val, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {		
		// 1. 전체 글의 갯수를 DB에 확인
		int totalRecordCount = noticeservice.totalCount();
		System.out.println("총 게시글 수" +totalRecordCount); // 2개 확인

		// 2. paginationInfo만들기
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalRecordCount);
		paginationInfo.setRecordCountPerPage(6);
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
		
		return "notice";
	}

	@GetMapping("/n_detail")
	public String notice(HttpServletRequest request, Model n_detail) {
		int no = Util.str2Int(request.getParameter("no"));
		n_detail.addAttribute("n_val", noticeservice.detail(no));
		
		System.out.println(noticeservice.detail(no));
		return "n_detail";
	}
	
	@GetMapping("/n_write")
	public String n_write(HttpSession session) {
		
		return "n_write";
	}
	
	@PostMapping("/n_write")
	public String n_write(HttpServletRequest request , HttpSession session , MultipartFile file) throws IOException {
		String n_title = request.getParameter("title");
		System.out.println("제목 : " + n_title);
		String n_content = request.getParameter("content");
		System.out.println("내용 : " + n_content);
		String admin_name = (String) session.getAttribute("name");
		System.out.println("이름 : " + admin_name);
		NoticeDTO noticedto = new NoticeDTO();
		noticedto.setN_title(n_title);
		noticedto.setN_content(n_content);
		noticedto.setAdmin_name(admin_name);
		
		noticeservice.write(noticedto);
		System.out.println(noticedto.getN_no());
		/*
		 * //첨부파일 수신 확인 System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 * 
		 * //첨부파일 저장 경로 설정 //스프링이 구동되고 있는 실제 경로 얻어오기 String realPath =
		 * context.getRealPath("resources/"); System.out.println("실제경로 : " + realPath);
		 * String upFilePath = realPath + "upfile/";
		 * 
		 * File cf_Path = new File(upFilePath); //경로가 없는 경우 if(!cf_Path.exists()) {
		 * cf_Path.mkdirs();//upfile폴더까지 경로를 모두 만들어 줌 }
		 * 
		 * 
		 * //중복된 이름의 파일의 덮어쓰기 오류를 해결하기 위해 UUID 생성 String newFileName =
		 * UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		 * 
		 * //파일 생성 new file(저장할 경로, 실제 올릴 파일명) File upFile = new File(cf_Path,
		 * newFileName); //실제 파일 전송(실제 파일객체, 경로+파일명이 있는 객체)
		 * FileCopyUtils.copy(file.getBytes(), upFile);
		 */
		
		//파일이 첨부되었다면 위의 과정을 메소드화한 메소드 실행하여 반환

		if(!file.isEmpty()) {
			String realPath = context.getRealPath("resources/");
			System.out.println(realPath);
			String fileName = util.fileSave(realPath ,file);
			
			noticedto.setN_file(fileName);
			noticeservice.filesave(noticedto);
			System.out.println("파일 저장 완료");
		}
		
		
		return "redirect:/notice";
	}
}
