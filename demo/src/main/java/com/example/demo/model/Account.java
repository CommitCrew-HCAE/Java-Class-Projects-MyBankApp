package com.example.demo.model;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;
    private AccountType accountType;
    private AccountStatus status;

    public Account(String accountNumber, String ownerName, BigDecimal balance,
                   AccountType accountType, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
