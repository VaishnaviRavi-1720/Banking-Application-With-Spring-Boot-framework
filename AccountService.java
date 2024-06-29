package com.web.service;

import com.web.entity.Account;

public interface AccountService 
{
   public Account saveAccount(Account account);

   public Account getBalance(int accountNumber);

   public Account deposit(int accountNumber, double amount);

   public Account withdraw(int accountNumber, double amount);

   public Account transferAmount(int fromAccountNumber, int toAccountNumber, double amount);

   public void closeAccount(int accountNumber);
    
   public Account getOneDetail(int accountNumber,String name,String password);
   
   public Account getDetail(int toAccountNumber);
}

