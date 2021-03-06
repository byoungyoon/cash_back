package com.example.cash.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cash.auth.JwtTokenUtil;
import com.example.cash.mapper.GuestBookMapper;
import com.example.cash.vo.GuestBook;

@Service
@Transactional
public class GuestBookService {
	@Autowired GuestBookMapper guestBookMapper;
	@Autowired JwtTokenUtil jwtTokenUtil;
	
	public List<GuestBook> getGuestBook(){
		return guestBookMapper.selectGuestBook();
	}
	
	public void modifyGuestBook(GuestBook guestBook) {
		guestBookMapper.updateGuestBook(guestBook);
	}
	
	public void removeGuestBook(int guestbookNo) {
		guestBookMapper.deleteGuestBook(guestbookNo);
	}
	
	public GuestBook getDetailGuestBook(int guestbookNo) {
		GuestBook guestBook = guestBookMapper.selectDetailGuestBook(guestbookNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("guestbookNo", guestBook.getGuestbookNo());
		map.put("guestbookCount", guestBook.getGuestbookCount());
		guestBookMapper.updateCountGuestBook(map);
		
		return guestBook;
	}
	
	public void addGusetBook(GuestBook guestBook, String token) {
		String userId = jwtTokenUtil.getToken(token);
		guestBook.setUserId(userId);
		
		int p = guestBook.getGuestbookImgFile().getOriginalFilename().lastIndexOf(".");
		String ext = guestBook.getGuestbookImgFile().getOriginalFilename().substring(p).toLowerCase();
		String fileName = UUID.randomUUID().toString().replace("-", "");
		guestBook.setGuestbookImg(fileName + ext);
		
		File file = new File("c://Users//bur56//images//" + fileName + ext);
		
		try {
			guestBook.getGuestbookImgFile().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		guestBookMapper.insertGusetBook(guestBook);
	}
}
