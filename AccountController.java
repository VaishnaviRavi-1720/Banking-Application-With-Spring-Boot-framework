package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.entity.Account;
import com.web.service.AccountServiceImp;

@Controller
public class AccountController
{

    @Autowired
    private AccountServiceImp service;

    @RequestMapping("/home")
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping("/newuser")
    public String displayRegisterPage(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @RequestMapping("/saveUser")
    public String saveUserRegistration(Account account) {
        service.saveAccount(account);
        return "success"; 
    }

    @RequestMapping("/balance")
    public String displayBalanceForm() {
        return "balanceForm"; 
    }

    @RequestMapping("/checkBalance")
    public String checkBalance(@RequestParam int accountNumber,@RequestParam String name,@RequestParam String password, ModelMap model) {
        Account account = service.getBalance(accountNumber);
        Account acc=service.getOneDetail(accountNumber,name,password);
        if(account != null&& acc!= null) {
        model.put("account", account);
        return "balanceResult";
        }
        else {
        	model.put("error","Can't Find Account");
        	return "error";
        }
    }

    @RequestMapping("/deposit")
    public String depositForm() {
        return "depositForm"; // assuming depositForm.jsp or depositForm.html exists
    }

    @RequestMapping("/processDeposit")
    public String processDeposit(@RequestParam int accountNumber, 
                                 @RequestParam double amount,
                                 @RequestParam String name,
                                 @RequestParam String password,ModelMap model) {
    	Account account=service.deposit(accountNumber, amount);
    	Account acc=service.getOneDetail(accountNumber, name, password);
    	if(account != null && acc!=null) {
    		model.put("balance", amount);
    		model.put("acc", acc);
    		return "successDeposit";
    	}
    	else {
        	model.put("error","Can't Find Account");
        	return "error";
        } 
    }

    @RequestMapping("/withdraw")
    public String withdrawForm() {
        return "withdrawForm"; // assuming withdrawForm.jsp or withdrawForm.html exists
    }

    @RequestMapping("/processWithdraw")
    public String processWithdraw(@RequestParam int accountNumber, 
                                  @RequestParam double amount,
                                  @RequestParam String name,
                                  @RequestParam String password,ModelMap model) {
    	Account account=service.withdraw(accountNumber, amount);
    	Account acc=service.getOneDetail(accountNumber, name, password);
    	if(acc!=null) {
    		if(account != null) {
    			model.put("balance", amount);
        		model.put("acc", acc);
    		return "successWithdraw"; 
    		}
    		else {
    			model.put("error", "Insufficient Balance");
    			return "error";
    		}
    	}
    	else {
        	model.put("error","Can't Find Account");
        	return "error";
        } 
        // assuming success.jsp or success.html exists
    }

    @RequestMapping("/transfer")
    public String transferForm() {
        return "transferForm"; // assuming transferForm.jsp or transferForm.html exists
    }

    @RequestMapping("/processTransfer")
    public String processTransfer(@RequestParam int fromAccountNumber,
                                  @RequestParam int toAccountNumber,
                                  @RequestParam double amount,
                                  @RequestParam String name,
                                  @RequestParam String password,ModelMap model) {
    	Account account=service.transferAmount(fromAccountNumber, toAccountNumber, amount);
    	Account acc=service.getOneDetail(fromAccountNumber, name, password);
    	Account transfer=service.getDetail(toAccountNumber);
    	if(acc != null) {
    		if(account != null) {
    			model.put("transfer", transfer);
    			model.put("acc", acc);
    			model.put("amount", amount);
    			return "successTransfer";
    		}
    		else {
    			model.put("error", "Insufficient Balance");
    			return "error";
    		}
    	}
    	else {
        	model.put("error","Can't Find Account");
        	return "error";
        }  
    }
    @RequestMapping("/closeaccount")
    public String displayCloseAccountForm() {
    	return "closeaccountForm";
    }

    @RequestMapping("/processCloseAccount")
    public String closeAccount(@RequestParam("accountNumber") int accountNumber,
    		@RequestParam String name,
            @RequestParam String password,ModelMap model) {
    	Account acc=service.getOneDetail(accountNumber, name, password);
        if(acc!= null){
    		service.closeAccount(accountNumber);
    		model.put("acc", acc);
    		return "successClose";
    	}
    	else {
        	model.put("error","Can't Find Account");
        	return "error";
        }  
    }
}

