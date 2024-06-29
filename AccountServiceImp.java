package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.entity.Account;
import com.web.repo.AccountRepo;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepo repo;

    @Override
    public Account saveAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getBalance(int accountNumber){
        return repo.findById(accountNumber).get();
    }

    @Override
    public Account deposit(int accountNumber, double amount) {
        Account account = repo.findById(accountNumber).get();
        if (account != null)
        {
            account.setAmount(account.getAmount() + amount);
            repo.save(account);
            return account;
        }
        else {
        return null;
        }
    }

    @Override
    public Account withdraw(int accountNumber, double amount) {
        Account account = repo.findById(accountNumber).get();
        if (account != null && account.getAmount() >= amount) {
            account.setAmount(account.getAmount() - amount);
            repo.save(account);
            return account;
        }
        else {
        	return null;
        }
    }

    @Override
    public Account transferAmount(int fromAccountNumber, int toAccountNumber, double amount) 
    {
        Account fromAccount = repo.findById(fromAccountNumber).get();
        Account toAccount = repo.findById(toAccountNumber).get();
        if (fromAccount != null && toAccount != null && fromAccount.getAmount() >= amount) {
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
            repo.save(fromAccount);
            repo.save(toAccount);
        }
        return fromAccount;
    }

    @Override
    public void closeAccount(int accountNumber) {
    	 repo.deleteById(accountNumber);
    }
    
    @Override
    public Account getOneDetail(int accountNumber,String name,String password){
    	Account acc=repo.findById(accountNumber).get();
    	if(acc.getName().equals(name) && acc.getPassword().equals(password)) {
        return acc;
    	}
    	return null;
    }
    @Override
    public Account getDetail(int toAccountNumber) {
    	return repo.findById(toAccountNumber).get();
    }
}
