package com.example.cash.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.GuestBook;

@Mapper
public interface GuestBookMapper {
	List<GuestBook> selectGuestBook();
	int updateGuestBook(GuestBook guestBook);
	int deleteGuestBook(int guestbookNo);
	int updateCountGuestBook(Map<String, Object> map);
	GuestBook selectDetailGuestBook(int guestbookNo);
	int insertGusetBook(GuestBook guestBook);
}
