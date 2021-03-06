package com.example.cash.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.cash.vo.Account;
import com.example.cash.vo.User;

@Mapper
public interface UserMapper {
	int updateUser(User user);
	User selectOneUser(String userId);
	User selectUserByLogin(String userId);
	int insertAccout(Account accout);
	int insertUser(User user);
	User selectUserId(String userId);
}
