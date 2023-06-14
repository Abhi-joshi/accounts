package com.abhishek.accounts.service.impl;

import com.abhishek.accounts.client.ConfigProperties;
import com.abhishek.accounts.config.AccountsConfig;
import com.abhishek.accounts.model.Account;
import com.abhishek.accounts.repository.AccountRepository;
import com.abhishek.accounts.service.AccountService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountsConfig accountsConfig;
    public AccountServiceImpl(AccountRepository accountRepository, AccountsConfig accountsConfig) {
        this.accountRepository = accountRepository;
        this.accountsConfig = accountsConfig;
    }

    @Override
    public Account findAccountDetails(long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    @Override
    public Mono<ConfigProperties> getProperties() {
       ConfigProperties configProperties = new ConfigProperties(this.accountsConfig.getMsg(), this.accountsConfig.getPassword());
       return Mono.just(configProperties);
    }
}
