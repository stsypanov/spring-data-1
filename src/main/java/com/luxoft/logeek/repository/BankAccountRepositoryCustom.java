package com.luxoft.logeek.repository;

import com.luxoft.logeek.entity.jira729.BankAccount;

import java.util.Optional;

public interface BankAccountRepositoryCustom {
    Optional<BankAccount> findWithHighestRate();
}
