package com.example.cash.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.CashbookService;
import com.example.cash.service.JwtUserDetailsService;
import com.example.cash.vo.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InfoRestController {
	@Autowired JwtUserDetailsService userService;
	@Autowired CashbookService cashbookService;
	
	@PostMapping("/user/modifyUser")
	public String modifyUser(User user,
			@RequestHeader(value = "Authorization", required = false) String token) {
		userService.modifyUser(user, token);
		return "";
	}
	
	@GetMapping("/user/getInfo")
	public Map<String, Object> getInfo(
			@RequestHeader(value = "Authorization", required = false) String token) {
		Map<String, Object> map = new HashMap<>();
		map.put("user", userService.getOneUser(token));
		map.put("incomeChart", cashbookService.getIncomeChart(token).get("incomeList"));
		map.put("outcomeChart", cashbookService.getIncomeChart(token).get("outcomeList"));
		
		return map;
	}
}
