package com.cg.walletaplcn.beans;

public class Transaction {

	String mobileNo;
	String msg;
	
	
	
	public Transaction(String mobileNo2, String trans) {
		// TODO Auto-generated constructor stub
		this.mobileNo=mobileNo2;
		this.msg=trans;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
