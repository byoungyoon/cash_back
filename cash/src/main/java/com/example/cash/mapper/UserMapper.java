package com.example.cash.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.User;

@Mapper
public interface UserMapper {
	User selectUserId(String userId);
}
