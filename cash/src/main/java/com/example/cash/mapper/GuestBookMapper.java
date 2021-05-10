package com.example.cash.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.GuestBook;

@Mapper
public interface GuestBookMapper {
	int insertGusetBook(GuestBook guestBook);
}
