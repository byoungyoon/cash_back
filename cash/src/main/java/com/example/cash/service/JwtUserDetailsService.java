package com.example.cash.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cash.mapper.UserMapper;
import com.example.cash.vo.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.selectUserId(username);
        if (user.getUserId().equals(username)) {
            user.setAuthorities(getAuthorities(user.getUserAuth()));
        	return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
	}
	
	// 권한테이블 안의 로그인한 사용자의 권한이 정보를 가져온다
    public Collection<GrantedAuthority> getAuthorities(String userAuth) {
        List<String> authList = new ArrayList<String>();
        authList.add(userAuth);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String authority : authList) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }
    
    public User getUserByLogin(String userId) {
    	return userMapper.selectUserByLogin(userId);
    }
	
	public void signup(User user) {
		userMapper.insertUser(user);
	}

}
