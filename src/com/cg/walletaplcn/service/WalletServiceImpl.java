package com.cg.walletaplcn.service;

import java.util.List;

import com.cg.walletaplcn.beans.Customer;
import com.cg.walletaplcn.dao.WalletDao;
import com.cg.walletaplcn.dao.WalletDaoImpl;
import com.cg.walletaplcn.exception.WalletException;

public class WalletServiceImpl implements WalletService
{

	WalletDao wdao=new WalletDaoImpl();
	@Override
	public Customer createAccount(String mobileNo, Customer c) {
		// TODO Auto-generated method stub
		return wdao.createAccount(c);
	}

	@Override
	public double showBalance(String mobileNo) throws WalletException{
		// TODO Auto-generated method stub
		return wdao.showBalance(mobileNo);
	}

	@Override
	public double deposit(String mobileNo, double amount) throws WalletException{
		// TODO Auto-generated method stub
		return wdao.deposit(mobileNo, amount);
	}

	@Override
	public double withdraw(String mobileNo, double amount) throws WalletException{
		// TODO Auto-generated method stub
		return wdao.withdraw(mobileNo, amount);
	}

	@Override
	public int fundTransfer(String mobileNo, String recMobileNo, double amount) throws WalletException{
		// TODO Auto-generated method stub
		return wdao.fundTransfer(mobileNo, recMobileNo, amount);
	}

	@Override
	public String printTransactions(String mobileNo) {
		// TODO Auto-generated method stub
		
		return wdao.printTransactions(mobileNo);
	}
	

}
