package com.abhishek.accounts.service;

import com.abhishek.accounts.client.ConfigProperties;
import com.abhishek.accounts.model.Account;
import reactor.core.publisher.Mono;


public interface AccountService {
    Account findAccountDetails(long customerId);
    Mono<ConfigProperties> getProperties();
}
