package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.AccountStatus;
import com.example.demo.model.AccountType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {

    // Temporary in-memory storage (will be replaced by DB later)
    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String ownerName, AccountType accountType) {
        String accountNumber = UUID.randomUUID().toString();

        Account account = new Account(
                accountNumber,
                ownerName,
                BigDecimal.ZERO,
                accountType,
                AccountStatus.ACTIVE
        );

        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean deposit(String accountNumber, BigDecimal amount) {
    Account account = accounts.get(accountNumber);
    if (account == null || account.getStatus() != AccountStatus.ACTIVE) {
        return false;
    }
    account.deposit(amount);
    return true;
}

public boolean withdraw(String accountNumber, BigDecimal amount) {
    Account account = accounts.get(accountNumber);
    if (account == null || account.getStatus() != AccountStatus.ACTIVE) {
        return false;
    }
    if (account.getBalance().compareTo(amount) < 0) {
        return false; // Not enough balance
    }
    account.withdraw(amount);
    return true;
}

}
