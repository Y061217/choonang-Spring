package com.poseidon.web.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.MemberDTO;
import com.poseidon.web.dao.FileDAO;

@Service
public class FileService {

	@Autowired
	private FileDAO fileDAO;

	public Workbook excelList() {

		// 데이터베이스에서 리스트 불러오기
		List<MemberDTO> list = fileDAO.memberList();

		Workbook wb = new HSSFWorkbook();

		Sheet sheet = wb.createSheet("회원정보");
		Row row = null;
		Cell cell = null;
		int rownum = 0;

		row = sheet.createRow(rownum++);
		cell = row.createCell(0);// 셀 위치
		cell.setCellValue("번호");

		cell = row.createCell(1);// 셀 위치 0 1 2 3 4 5
		cell.setCellValue("아이디");

		cell = row.createCell(2);
		cell.setCellValue("암호");

		cell = row.createCell(3);
		cell.setCellValue("이름");

		cell = row.createCell(4);
		cell.setCellValue("나이");

		cell = row.createCell(5);
		cell.setCellValue("전화번호");

		cell = row.createCell(6);
		cell.setCellValue("email");

		// int i = 0;
		for (MemberDTO dto : list) {
			row = sheet.createRow(rownum++);
			cell = row.createCell(0);
			cell.setCellValue(dto.getMember_no());

			cell = row.createCell(1);
			cell.setCellValue(dto.getMember_id());

			cell = row.createCell(2);
			cell.setCellValue(dto.getMember_pw());

			cell = row.createCell(3);
			cell.setCellValue(dto.getMember_name());

			cell = row.createCell(4);
			cell.setCellValue(dto.getMember_age());

			cell = row.createCell(5);
			cell.setCellValue(dto.getMember_tel());

			cell = row.createCell(6);
			cell.setCellValue(dto.getMember_email());
		}
		for (int i = 0; i < list.get(0).getClass().getDeclaredFields().length; i++) {
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i)+256);
		}

		return wb;
	}
}
