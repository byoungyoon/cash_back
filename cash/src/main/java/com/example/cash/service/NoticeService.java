package com.example.cash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cash.mapper.NoticeMapper;
import com.example.cash.vo.Notice;

@Service
@Transactional
public class NoticeService {
	@Autowired NoticeMapper noticeMapper;
	
	public List<Notice> getNotice(){
		return noticeMapper.selectNotice();
	}
}
