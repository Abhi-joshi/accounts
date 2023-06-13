package com.abhishek.accounts.controller;

import com.abhishek.accounts.client.ConfigProperties;
import com.abhishek.accounts.model.Account;
import com.abhishek.accounts.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountsController {
    private final AccountService accountService;
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/details/{customerId}")
    public Account accountDetails(@PathVariable long customerId){
        return accountService.findAccountDetails(customerId);
    }

    @GetMapping("/properties")
    public Mono<ConfigProperties> properties() {
        return accountService.getProperties();
    }

}
