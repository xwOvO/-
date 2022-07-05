package com.admin.model;

public class Borrow {
	private Integer sid;//����id
	private Integer bid;//�����id
	private String borrowTime;//����ʱ��
	private String dueTime;//Ӧ��ʱ��
	private String returnTime;//����ʱ��
	
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Borrow(Integer sid, Integer bid, String borrowTime, String dueTime) {
		super();
		this.sid = sid;
		this.bid = bid;
		this.borrowTime = borrowTime;
		this.dueTime = dueTime;
	}

	
	public Borrow(Integer sid, Integer bid) {
		super();
		this.sid = sid;
		this.bid = bid;
	}

	
	public Borrow(Integer sid) {
		super();
		this.sid = sid;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}
	public String getDueTime() {
		return dueTime;
	}
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	
}
