package com.cipherbyte;

import java.util.ArrayList;
import java.util.List;

class Account{
	private int accountId;
	private String accountHolder;
	private double balance;
	
	public Account(int accountId,String accountHolder) {
		this.accountId=accountId;
		this.accountHolder=accountHolder;
		this.balance=0.0;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance+=amount;
	}
	
	public boolean withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void transfer(Account receiver,double amount) {
		if(withdraw(amount)) {
			receiver.deposit(amount);
			System.out.println(amount+" transferred successfully to "+receiver.getAccountHolder());
		}
		else {
			System.out.println("Insufficient balance to tranfer.");
		}
	}
}

class Bank{
	private List<Account>accounts;
	private int nextAccountId;
	
	public Bank() {
		this.accounts=new ArrayList<>();
		this.nextAccountId=1;
	}
	
	public void createAccount(String accountHolder) {
		Account newAccount=new Account(nextAccountId++,accountHolder);
		accounts.add(newAccount);
		System.out.println("Account created successfully.Account ID:"+newAccount.getAccountId());
	}
	
	public Account findAccountById(int accountId) {
		for(Account account:accounts) {
			if(account.getAccountId()==accountId) {
				return account;
			}
		}
		return null;
	}
	
	public void deposit(int accountId,double amount) {
		Account account=findAccountById(accountId);
		if(account!=null) {
			account.deposit(amount);
			System.out.println(amount+" deposited successfully to account "+accountId);
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	public void withdraw(int accountId,double amount) {
		Account account=findAccountById(accountId);
		if(account!=null) {
			if(account.withdraw(amount)) {
				System.out.println(amount+" withdrawn successfully from account "+accountId);
			}
			else {
				System.out.println("Insufficient balance.");
			}
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	public void tranfer(int senderId,int receiverId,double amount) {
		Account sender=findAccountById(senderId);
		Account receiver=findAccountById(receiverId);
		if(sender!=null && receiver!=null) {
			sender.transfer(receiver, amount);
		}
		else {
			System.out.println("One or both accounts not found.");
		}
	}
	
	public void displayAccountInfo(int accountId) {
		Account account=findAccountById(accountId);
		if(account!=null) {
			System.out.println("Account ID: "+account.getAccountId());
			System.out.println("Account Holder: "+account.getAccountHolder());
			System.out.println("Balance: "+account.getBalance());
		}
		else {
			System.out.println("Account not found.");
		}
	}
}

public class BankY {
	public static void main(String[] args) {
		Bank bank=new Bank();
		
		bank.createAccount("Alice");
		bank.createAccount("Bob");
		
		bank.deposit(1, 1000);
		bank.withdraw(1,200);
		bank.tranfer(1, 2, 300);
		
		bank.displayAccountInfo(1);
		bank.displayAccountInfo(2);
	}
}