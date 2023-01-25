package com.poseidon.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DrawService {

	public List<String> result(String names) {

		Set<String> winners = new HashSet<String>();

		String[] a = names.split(",");

		for (String string : a) {
			String t = string.trim();
			winners.add(t);
		}
		List<String> result = new ArrayList<String>(winners);

		Collections.shuffle(result);

		System.out.println(result);

		return result;
	}

}
