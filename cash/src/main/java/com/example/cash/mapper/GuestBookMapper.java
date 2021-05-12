package com.example.cash.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.GuestBook;

@Mapper
public interface GuestBookMapper {
	int updateGuestBook(GuestBook guestBook);
	int deleteGuestBook(int guestbookNo);
	int updateCountGuestBook(Map<String, Object> map);
	GuestBook selectDetailGuestBook(int guestbookNo);
	int insertGusetBook(GuestBook guestBook);
}
