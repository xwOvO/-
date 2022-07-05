package com.admin.model;

public class Borrow {
	private Integer sid;//读者id
	private Integer bid;//借的书id
	private String borrowTime;//借书时间
	private String dueTime;//应还时间
	private String returnTime;//还书时间
	
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
