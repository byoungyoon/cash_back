package com.example.cash.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.GuestBookService;
import com.example.cash.vo.GuestBook;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GuestBookRestController {
	@Autowired GuestBookService guestBookService;
	
	@GetMapping("/user/getDetailGuestBook")
	public GuestBook getDetailGuestBook(
			@RequestParam(value="guestbookNo", required = false) int guestbookNo) {
		return guestBookService.getDetailGuestBook(guestbookNo);
	}
	
	@PostMapping("/user/addGuestBook")
	public String addGusetBook(GuestBook guestBook,
			@RequestHeader(value="Authorization", required = false) String token) {
		guestBookService.addGusetBook(guestBook, token);
		return "";
	}
}
