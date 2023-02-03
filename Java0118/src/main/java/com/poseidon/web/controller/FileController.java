package com.poseidon.web.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poseidon.web.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileservice;

	@GetMapping("/fileDown.xls")
	public void fileDown(HttpServletResponse response) throws IOException {
		//System.out.println("정상 접근 입니다");
		ServletOutputStream out = response.getOutputStream();
		/*
		 * String text = "한글"; text = new String(text.getBytes("KSC5601"), "8859_1");
		 * out.println(text); out.close();
		 */
		Workbook wb = fileservice.excelList();
		wb.write(out);
		out.close();
	}
}
