package com.cg.walletaplcn.dao;

import java.util.List;

import com.cg.walletaplcn.beans.Customer;
import com.cg.walletaplcn.exception.WalletException;

public interface WalletDao {
	 Customer createAccount(Customer c);
	 double showBalance(String mobileNo) throws WalletException;
	 double deposit(String mobileNo,double amount) throws WalletException;
	 double withdraw(String mobileNo,double amount) throws WalletException;
	 int fundTransfer(String mobileNo,String recMobileNo,double amount) throws WalletException;
	 String printTransactions(String mobileNo);
 
}
