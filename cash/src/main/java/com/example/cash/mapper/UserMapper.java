package com.example.cash.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.User;

@Mapper
public interface UserMapper {
	User selectUserByLogin(String userId);
	int insertUser(User user);
	User selectUserId(String userId);
}
