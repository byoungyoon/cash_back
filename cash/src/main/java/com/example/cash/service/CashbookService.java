package com.example.cash.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cash.auth.JwtTokenUtil;
import com.example.cash.mapper.CashbookMapper;
import com.example.cash.vo.Cashbook;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CashbookService {
	@Autowired CashbookMapper cashbookMapper;
	@Autowired JwtTokenUtil jwtTokenUtil;
	
	public Map<String, List<Integer>> getIncomeChart(String token){
		token = token.substring(7);
		String userId = null;
		try {
			userId = jwtTokenUtil.getUsernameFromToken(token);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		List<Cashbook> incomeListData = cashbookMapper.selectIncomeChart(userId);
		List<Cashbook> outcomeListData = cashbookMapper.selectOutcomeChart(userId);
		List<Integer> incomeList = new ArrayList<>();
		List<Integer> outcomeList = new ArrayList<>();
		boolean incomeCheck = false;
		boolean outcomeCheck = false;
		for(int i=1; i<13; i++) {
			for(int j=0; j<incomeListData.size(); j++) {
				if(incomeListData.get(j).getCashbookMonth() == i) {
					incomeCheck = true;
					incomeList.add(incomeListData.get(j).getCashbookPrice());
					break;
				}
			}
			for(int j=0; j<outcomeListData.size(); j++) {
				if(outcomeListData.get(j).getCashbookMonth() == i) {
					outcomeCheck = true;
					outcomeList.add(outcomeListData.get(j).getCashbookPrice());
					break;
				}
			}
			if(!incomeCheck) {
				incomeList.add(0);
			}
			if(!outcomeCheck) {
				outcomeList.add(0);
			}
			incomeCheck = false;
			outcomeCheck = false;
		}
		
		Map<String, List<Integer>> map = new HashMap<>();
		
		map.put("incomeList", incomeList);
		map.put("outcomeList", outcomeList);
		
		return map;
	}
}
