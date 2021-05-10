package com.example.cash.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GuestBook {
	private int guestbookNo;
	private String userId;
	private String guestbookTitle;
	private String guestbookContent;
	private String guestbookImg;
	private MultipartFile guestbookImgFile;
	private int guestbookCount;
	private String createDate;
	private String lastUpdate;
}
