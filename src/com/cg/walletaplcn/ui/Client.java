package com.cg.walletaplcn.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cg.walletaplcn.beans.Customer;
import com.cg.walletaplcn.exception.WalletException;
import com.cg.walletaplcn.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args)
	{
		WalletServiceImpl ser=new WalletServiceImpl();

		String mobileNo,recmobileNo,mailid,name;
		double balance = 0,amount;
		int choice;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Options:");
		System.out.println("1.Create Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Print Transactions");
		System.out.println("7.Exit");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		String recMobileNo;
		switch(choice)
		{
		case 1:
			System.out.println("Enter mobile number");
			mobileNo=sc.next();
			System.out.println("Enter user name");
			name=sc.next();
			System.out.println("Enter mailid");
			mailid=sc.next();
			Customer c=new Customer(name,mobileNo,mailid,balance);
			 c=ser.createAccount(mobileNo, c);
			break;
		case 2:
			
			System.out.println("Enter mobile number");
			mobileNo=sc.next();
			try {
				balance=ser.showBalance(mobileNo);
				System.out.println("Your balance is RS."+balance);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Enter mobile number");
			mobileNo=sc.next();
			System.out.println("Enter deposit amount");
			amount=sc.nextDouble();
			try {
				double depamount=ser.deposit(mobileNo, amount);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Enter mobile number:");
			mobileNo=sc.next();
			System.out.println("Enter withdrawal amount");
			amount=sc.nextDouble();
			try {
				double withdrawamount=ser.withdraw(mobileNo, amount);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 5:
			System.out.println("Enter sender mobile number");
			mobileNo=sc.next();
			System.out.println("Enter receiver mobile number");
			recMobileNo=sc.next();
			System.out.println("Enter amount to transfer");
			amount=sc.nextDouble();
			try {
				ser.fundTransfer(mobileNo, recMobileNo, amount);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Enter mobile number");
			mobileNo=sc.next();
			String trans=ser.printTransactions(mobileNo);
			System.out.println(trans);
			//Object transaction = null;
			//System.out.println((Arrays.asList(transaction)));
			break;
		case 7:
			System.out.println("Thank you!!");
			break;
		default:
			System.out.println("Invalid option");
			
		}
		}while(choice!=7);
	}
}
