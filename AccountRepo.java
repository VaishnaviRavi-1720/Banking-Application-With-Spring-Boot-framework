package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	 Account findByAccountNumberAndNameAndPassword(int accountNumber, String name, String password);
}
