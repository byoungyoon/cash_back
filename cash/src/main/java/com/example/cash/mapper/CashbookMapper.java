package com.example.cash.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.Cashbook;
import com.example.cash.vo.CashbookDetail;

@Mapper
public interface CashbookMapper {
	List<CashbookDetail> selectCashbookDetail(Map<String, Object> map);
	List<Cashbook> selectCashbookByMonth(Map<String, Object> map);
	List<Cashbook> selectOutcomeChart(String userId);
	List<Cashbook> selectIncomeChart(String userId);
}
