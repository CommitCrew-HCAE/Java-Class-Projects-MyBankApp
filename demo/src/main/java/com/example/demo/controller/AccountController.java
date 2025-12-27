package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.AccountType;
import com.example.demo.service.AccountService;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(
            @RequestParam String ownerName,
            @RequestParam AccountType accountType
    ) {
        return accountService.createAccount(ownerName, accountType);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/{accountNumber}/deposit")
public String deposit(
        @PathVariable String accountNumber,
        @RequestParam BigDecimal amount
) {
    boolean success = accountService.deposit(accountNumber, amount);
    return success ? "Deposit successful" : "Deposit failed";
}

@PostMapping("/{accountNumber}/withdraw")
public String withdraw(
        @PathVariable String accountNumber,
        @RequestParam BigDecimal amount
) {
    boolean success = accountService.withdraw(accountNumber, amount);
    return success ? "Withdrawal successful" : "Withdrawal failed";
}


}
