package com.abhishek.accounts.service.impl;

import com.abhishek.accounts.client.ConfigProperties;
import com.abhishek.accounts.config.AccountsServiceConfig;
import com.abhishek.accounts.model.Account;
import com.abhishek.accounts.repository.AccountRepository;
import com.abhishek.accounts.service.AccountService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountsServiceConfig accountsServiceConfig;
    public AccountServiceImpl(AccountRepository accountRepository, AccountsServiceConfig accountsServiceConfig) {
        this.accountRepository = accountRepository;
        this.accountsServiceConfig = accountsServiceConfig;
    }

    @Override
    public Mono<Account> findAccountDetails(long customerId) {
        return Mono.just(accountRepository.findByCustomerId(customerId));
    }

    @Override
    public Mono<ConfigProperties> getProperties() {
       ConfigProperties configProperties = new ConfigProperties(this.accountsServiceConfig.getMsg());
       return Mono.just(configProperties);
    }
}
