package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create account
    @PostMapping
    public Account createAccount(
            @RequestParam String ownerName,
            @RequestParam String accountType
    ) {
        return accountService.createAccount(ownerName, accountType);
    }

    // Get account by account number
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    // Deposit
    @PostMapping("/{accountNumber}/deposit")
    public String deposit(
            @PathVariable String accountNumber,
            @RequestParam double amount
    ) {
        accountService.deposit(accountNumber, amount);
        return "Deposit successful";
    }

    // Withdraw
    @PostMapping("/{accountNumber}/withdraw")
    public String withdraw(
            @PathVariable String accountNumber,
            @RequestParam double amount
    ) {
        accountService.withdraw(accountNumber, amount);
        return "Withdrawal successfull";
    }
}
