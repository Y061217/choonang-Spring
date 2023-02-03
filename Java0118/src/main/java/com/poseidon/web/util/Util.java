package com.poseidon.web.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Component
public class Util {
	
	public static int str2Int(String str) {
		return Integer.parseInt(str);
	}
	
	public String changeText(String txt) {
		txt = txt.replaceAll("<", "$lt;")
				 .replaceAll(">", "$gt;")
				 .replaceAll("\r", "\n")
				 .replaceAll("\n\r", "\n");
		return txt;
	}
	
	public String fileSave(String path, MultipartFile file) throws IOException {
		File upFile = new File(path + "upfile/");
		if(!upFile.exists()) {
			upFile.mkdirs();//경로 생성
		}
		//유니크한 파일명 만들기(UUID)
		String newFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		upFile = new File(upFile, newFileName);
		FileCopyUtils.copy(file.getBytes(), upFile);
		return newFileName;
	}
	
	
}
