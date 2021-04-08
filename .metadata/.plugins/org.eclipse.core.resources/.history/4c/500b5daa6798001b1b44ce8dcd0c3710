package com.example.cash.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.NoticeService;
import com.example.cash.vo.Notice;

@RestController
public class NoticeRestController {
	@Autowired NoticeService noticeService;
	
	@GetMapping("/getNotice")
	public List<Notice> getNotice(){
		return noticeService.getNotice();
	}
}
