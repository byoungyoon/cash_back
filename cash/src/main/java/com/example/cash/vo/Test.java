package com.example.cash.vo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();
		
		String[] start = {"a","a","b","c"};
		String[] end = {"a","c","b"};
		
		for(String s : start) {
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		for(String s : end) {
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		
		for(String key: hm.keySet()) {
			if(hm.get(key) % 2 != 1) {
				continue;
			}
			System.out.println(key);
		}
	}
}