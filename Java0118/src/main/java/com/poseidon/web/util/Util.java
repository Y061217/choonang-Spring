package com.poseidon.web.util;

import org.springframework.stereotype.Component;
@Component
public class Util {
	
	public int str2Int(String str) {
		return Integer.parseInt(str);
	}
	
	public String changeText(String txt) {
		txt = txt.replaceAll("<", "$lt;")
				 .replaceAll(">", "$gt;")
				 .replaceAll("\r", "\n")
				 .replaceAll("\n\r", "\n");
		return txt;
	}
	
	
}
