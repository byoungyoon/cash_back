package com.example.cash.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.Cashbook;

@Mapper
public interface CashbookMapper {
	List<Cashbook> selectOutcomeChart(String userId);
	List<Cashbook> selectIncomeChart(String userId);
}
