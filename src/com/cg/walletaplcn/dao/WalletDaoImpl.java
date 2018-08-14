package com.cg.walletaplcn.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cg.walletaplcn.beans.Customer;
import com.cg.walletaplcn.beans.Transaction;
import com.cg.walletaplcn.exception.WalletException;

public class WalletDaoImpl implements WalletDao{

	HashMap<String,Customer> custdb=new HashMap<String,Customer>();
	
	HashMap<String,String> transaction=new HashMap<String,String>();
	public String st="Details\n";
	
	
	public WalletDaoImpl()
	{
		custdb.put("9712348950",new Customer("sravani","9712348950","sravaniboddapati28@gmail.com",500.0));
		custdb.put("9712348951",new Customer("aishwarya","9712348951","aishabc@gmail.com",600.0));
		custdb.put("9712348952",new Customer("john","9712348952","johnxyz@gmail.com",450.0));
		custdb.put("9712348953",new Customer("tom","9712348953","tomjerry@gmail.com",300.0));
	}
	@Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
		custdb.put(c.getMobileNo(), c);
		//System.out.println(c);
		return c;
	}

	@Override
	public double showBalance(String mobileNo) throws WalletException{
		// TODO Auto-generated method stub
		
		if(mobileNo.length()==10)
		{
			if(custdb.containsKey(mobileNo))
			{
				double balance=custdb.get(mobileNo).getBalance();
				return balance;
			}
			else
			{
				throw new WalletException("mobile number doesn't exist in database");
			}
		}
		else
		{
			throw new WalletException("mobile number should be of 10digits.");
		}
	}

	@Override
	public double deposit(String mobileNo, double amount) throws WalletException{
		// TODO Auto-generated method stub
		//System.out.println(st);
		if(mobileNo.length()==10)
		{
			if(custdb.containsKey(mobileNo))
			{
				if(amount>0)
				{
					double balance=custdb.get(mobileNo).getBalance()+amount;
					double nb=custdb.get(mobileNo).setBalance(balance);
					String trans="Amount of Rs."+amount+" is deposited";
					//st=transaction.get(mobileNo);
					//System.out.println("st is"+st.length());
					

					st=transaction.get(mobileNo)+"\n"+trans;
					transaction.put(mobileNo,st );
					return nb;
				}
				else
				{
					throw new WalletException("invalid deposit amount");
				}
			}
			else
			{
				throw new WalletException("mobile number doesn't exist");
			
			}
		}
		else
		{
			throw new WalletException("mobile number should be of 10digits");
		}
		
	}
		

	@Override
	public double withdraw(String mobileNo, double amount) throws WalletException{
		// TODO Auto-generated method stub
		if(mobileNo.length()==10)
		{
			if(custdb.containsKey(mobileNo))
			{
				if(amount<custdb.get(mobileNo).getBalance())
				{
			
				double balance=custdb.get(mobileNo).getBalance()-amount;
				double nb=custdb.get(mobileNo).setBalance(balance);
				String trans="Amount of Rs."+amount+" is withdrawn";
				//st=st+transaction.get(mobileNo);
				st=transaction.get(mobileNo)+"\n"+trans;
				transaction.put(mobileNo,st);
				return nb;
				}
				else
				{
				throw new WalletException("Balance is too low");
				}
			}
			else
			{
				throw new WalletException("mobile number doesn't exist in database");
			}
		}
		else
		{
			throw new WalletException("mobile number should be of 10digits");
		}
	}

	@Override
	public int fundTransfer(String mobileNo, String recMobileNo,double amount) throws WalletException
	{
		
		// TODO Auto-generated method stub
		if(mobileNo.length()==10)
		{
		if(recMobileNo.length()==10)
		{
		if(custdb.containsKey(mobileNo))
		{
			
			
			if(custdb.containsKey(recMobileNo))
			{
				
				if(custdb.get(mobileNo).getBalance()>amount)
				{
					
				double bal1=custdb.get(mobileNo).getBalance()-amount;
				custdb.get(mobileNo).setBalance(bal1);
				double bal2=custdb.get(recMobileNo).getBalance()+amount;
				custdb.get(recMobileNo).setBalance(bal2);
				String trans="Amount of Rs."+amount+" is transferred to "+recMobileNo;
				//st=st+transaction.get(mobileNo);
				st=transaction.get(mobileNo)+trans;
				transaction.put(mobileNo,st);
				return (int) bal1;
				}
				else
				{
					throw new WalletException("Insufficient balance");
				}
			}
			else
			{
				throw new WalletException("receiver mobile number not found");
			}
		}
		else
		{
				
			throw new WalletException("invalid number");
		}
		}
		else
		{
			throw new WalletException("mobile number should be of 10digits");
		}
		}
		else
		{
			throw new WalletException("mobile number should be of 10digits");
		}
		}
	
	
	@Override
	public String printTransactions(String mobileNo)
	{
		String st=transaction.get(mobileNo).replaceAll("null","");
		return st;
		
	}
	
				
	}
	
