package com.cg.walletaplcn.beans;

public class Customer {

	String mobileNo,mailid,name;
	double balance,amount;
	
	
	public Customer(String name, String mobileNo, String mailid, double balance) {
		
		
		this.mobileNo = mobileNo;
		this.mailid = mailid;
		this.balance = balance;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getDepositAmount() {
		return amount;
	}
	public void setDepositAmount(double depositAmount) {
		this.amount = amount;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public double getBalance() {
		return balance;
	}
	public double setBalance(double balance) {
		return this.balance = balance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+mobileNo+"\t"+mailid+"\t"+balance;
	}
}
