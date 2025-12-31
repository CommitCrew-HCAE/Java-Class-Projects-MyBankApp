package com.example.demo.controller.PageController;

import com.example.demo.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final AccountService accountService;

    public PageController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Create account page
    @GetMapping("/create-account")
    public String createAccountPage() {
        return "create-account";
    }

    // Handle create account
    @PostMapping("/create-account")
    public String createAccount(
            @RequestParam String ownerName,
            @RequestParam String accountType,
            Model model
    ) {
        Account account = accountService.createAccount(ownerName, accountType);
        model.addAttribute("account", account);
        return "account";
    }

    // Deposit page
    @GetMapping("/deposit")
    public String depositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(
            @RequestParam String accountNumber,
            @RequestParam double amount,
            Model model
    ) {
        accountService.deposit(accountNumber, amount);
        Account account = accountService.getAccount(accountNumber);
        model.addAttribute("account", account);
        return "account";
    }

    // Withdraw page
    @GetMapping("/withdraw")
    public String withdrawPage() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(
            @RequestParam String accountNumber,
            @RequestParam double amount,
            Model model
    ) {
        accountService.withdraw(accountNumber, amount);
        Account account = accountService.getAccount(accountNumber);
        model.addAttribute("account", account);
        return "account";
    }
}

// Minimal AccountService interface added locally to satisfy compilation.
// Implement the real service in the proper package when available.
interface AccountService {
    Account createAccount(String ownerName, String accountType);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    Account getAccount(String accountNumber);
}
