package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.datajpa729.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountOwnerChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankAccountOwnerCheckerImpl implements BankAccountOwnerChecker {
    private final BankAccountRepository repository;
    @Override
    public void checkIfOwnerExists(Long accountId) {
        repository.findById(accountId).map(BankAccount::getUser).orElseThrow(RuntimeException::new);
    }
}
