package com.example.cash.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.JwtUserDetailsService;
import com.example.cash.vo.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InfoRestController {
	@Autowired JwtUserDetailsService userService;
	
	@GetMapping("/user/getInfo")
	public User getInfo(
			@RequestHeader(value = "Authorization", required = false) String token) {
		
		return userService.getOneUser(token);
	}
}
