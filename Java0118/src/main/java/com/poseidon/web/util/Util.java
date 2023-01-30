package com.poseidon.web.util;

import org.springframework.stereotype.Component;
@Component
public class Util {
	public String changeText(String txt) {
		txt = txt.replaceAll("<", "$lt;")
				 .replaceAll(">", "$gt;");
		
		return txt;
	}
	
	
}
