package com.example.cash.vo;

import lombok.Data;

@Data
public class Cashbook {
	private int cashbookNo;
	private String userId;
	private String cashbookInfo;
	private String cashbookTitle;
	private int cashbookPrice;
	private int cashbookMonth;
	private int cashbookDay;
	private String cashbookContent;
	private String cashbookDate;
	private String createDate;
	private String lastUpdate;
}
