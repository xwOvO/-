package com.admin.model;

import java.sql.Date;

public class Book {
	private Integer id;//���
	private String bookName;//ͼ������
	private String author;//����
	private String publisher;//ͼ�������
	private String pubdate;//ͼ���������
	private String summary;//ͼ������ժҪ
	private int total;//ͼ������
	private int nowNum;//ͼ��Ŀǰ�ڹ�����
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(Integer id, String bookName, String author, String publisher) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}


	public Book(Integer id, String bookName, String author, String publisher, String pubdate, String summary,
			int nowNum) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.summary = summary;
		this.nowNum = nowNum;
	}


	public Book(String bookName, String author, String publisher, String pubdate, String summary, int nowNum) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.summary = summary;
		this.nowNum = nowNum;
	}


	public Book(String bookName, String author, String publisher) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPubdate() {
		return pubdate;
	}


	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getNowNum() {
		return nowNum;
	}


	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}


	
	
	
}
