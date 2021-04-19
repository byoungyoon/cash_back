package com.example.cash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cash.mapper.CashbookMapper;
import com.example.cash.vo.Cashbook;

@Service
@Transactional
public class CashbookService {
	@Autowired CashbookMapper cashbookMapper;
	
	public List<Cashbook> getIncomeChart(Cashbook cashbook){
		return cashbookMapper.selectIncomeChart(cashbook);
	}
}
