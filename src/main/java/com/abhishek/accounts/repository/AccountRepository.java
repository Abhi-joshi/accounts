package com.abhishek.accounts.repository;

import com.abhishek.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCustomerId(long customerId);
}
