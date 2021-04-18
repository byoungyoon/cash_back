package com.example.cash.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.JwtUserDetailsService;
import com.example.cash.vo.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InfoRestController {
	@Autowired JwtUserDetailsService userService;
	
	@PostMapping("/user/modifyUser")
	public String modifyUser(User user,
			@RequestHeader(value = "Authorization", required = false) String token) {
		userService.modifyUser(user, token);
		return "";
	}
	
	@GetMapping("/user/getInfo")
	public User getInfo(
			@RequestHeader(value = "Authorization", required = false) String token) {
		
		return userService.getOneUser(token);
	}
}
