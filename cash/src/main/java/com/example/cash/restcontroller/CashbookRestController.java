package com.example.cash.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.service.CashbookService;
import com.example.cash.vo.Cashbook;
import com.example.cash.vo.CashbookDetail;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CashbookRestController {
	@Autowired CashbookService cashbookService;
	
	@GetMapping("/user/getCashbookDetail")
	public List<CashbookDetail> getCashbookDetail(
			@RequestParam(value="currentDay", required = false) String currentDay,
			@RequestHeader(value="Authorization", required = false) String token){
		return cashbookService.getCashbookDetail(currentDay, token);
	}
	
	@GetMapping("/user/getCashbook")
	public List<Cashbook> getCashbookByMonth(
			@RequestParam(value="currentMonth", required = false) String currentMonth,
			@RequestHeader(value="Authorization", required = false) String token){
		
		return cashbookService.getCashbookByMonth(currentMonth, token);
	}
}
