package com.cg.walletaplcn.testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.cg.walletaplcn.beans.Customer;
import com.cg.walletaplcn.dao.WalletDaoImpl;
import com.cg.walletaplcn.exception.WalletException;
import com.cg.walletaplcn.service.WalletServiceImpl;

public class Wallet_test {
	WalletServiceImpl service=new WalletServiceImpl();
	WalletDaoImpl walldao=new WalletDaoImpl();
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
		
		@Test
		public void showBalanceTest() throws WalletException
		{
			try {
				assertEquals(300.0,walldao.showBalance("9712348953"),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void showBalanceTest1() throws WalletException
		{
			try {
				assertEquals("mobile number doesn't exist in database",walldao.showBalance("9712348954"));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void depositTest() throws WalletException
		{
			assertEquals(600.0,walldao.deposit("9712348950", 100.0),0);
			
		}
		@Test
		public void depositTest1() throws WalletException
		{
			//assertEquals("mobile number doesn't exist",walldao.deposit("9712348954", 100.0));
			try {
				assertEquals("mobile number doesn't exist",walldao.deposit("9712348954",100.0));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void depositTest2() throws WalletException
		{
			//assertEquals("mobile number doesn't exist",walldao.deposit("9712348954", 100.0));
			try {
				assertEquals("invalid deposit amount",walldao.deposit("9712348954",-10));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void depositTest3() throws WalletException
		{
			//assertEquals("mobile number doesn't exist",walldao.deposit("9712348954", 100.0));
			try {
				assertEquals("mobile number should be of 10digits",walldao.deposit("97123489",100.0));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void withdrawTest() throws WalletException
		{
			try {
				assertEquals(400.0,walldao.withdraw("9712348950", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void withdrawTest1() throws WalletException
		{
			try {
				assertEquals("Balance is too low",walldao.withdraw("9712348950", 600.0));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void withdrawTest2() throws WalletException
		{
			try {
				assertEquals("mobile number doesn't exist in database",walldao.withdraw("9712348955", 600.0));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void withdrawTest3() throws WalletException
		{
			try {
				assertEquals("mobile number should be of 10digits",walldao.withdraw("97123489", 600.0));
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void fundTransferTest() throws WalletException
		{
			try {
				assertEquals(400.0,walldao.fundTransfer("9712348950", "9712348951", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void fundTransferTest1() throws WalletException
		{
			try {
				assertEquals("invalid number",walldao.fundTransfer("9712348955", "9712348951", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void fundTransferTest2() throws WalletException
		{
			try {
				assertEquals("receiver mobile number not found",walldao.fundTransfer("9712348950", "9712348955", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void fundTransferTest3() throws WalletException
		{
			try {
				assertEquals("mobile number should be of 10digits",walldao.fundTransfer("971234895", "9712348955", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void fundTransferTest4() throws WalletException
		{
			try {
				assertEquals("mobile number should be of 10digits",walldao.fundTransfer("9712348950", "971234895", 100.0),0);
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void printTransactionsTest() throws WalletException
		{
			walldao.deposit("9712348950", 150.0);
			walldao.withdraw("9712348950", 50.0);
			assertEquals("\n" + "Amount of Rs.150.0 is deposited\n" + "Amount of Rs.50.0 is withdrawn",walldao.printTransactions("9712348950"));
		}
		@Test
		/*public String toString()
		{
			return walldao.createAccount(new Customer("abc","9885286863", "xyz@gmail.com", 0.0));
			
		}*/
		public void createAccountTest() 
		{
			Customer c=new Customer("abc","9885286863", "xyz@gmail.com", 0.0);
			
			//String t= walldao.createAccount(new Customer("abc","9885286863", "xyz@gmail.com", 0.0))
			assertEquals("abc"+"\t"+"9885286863"+"\t"+"xyz@gmail.com"+"\t"+0.0,walldao.createAccount(new Customer("abc","9885286863", "xyz@gmail.com", 0.0)));
		}
		
	}


	