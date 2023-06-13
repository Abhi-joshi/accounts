package com.abhishek.accounts.service.impl;

import com.abhishek.accounts.model.Account;
import com.abhishek.accounts.repository.AccountRepository;
import com.abhishek.accounts.service.AccountService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Mono<Account> findAccountDetails(long customerId) {
        return Mono.just(accountRepository.findByCustomerId(customerId));
    }
}
