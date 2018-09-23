package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.repository.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountChecker;
import com.luxoft.logeek.service.BankAccountOwnerChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankAccountCheckerImpl implements BankAccountChecker {
    private final BankAccountRepository repository;
    private final BankAccountOwnerChecker bankAccountOwnerChecker;

    @Override
    public boolean checkAccount(Long accountId) {
        bankAccountOwnerChecker.checkIfOwnerExists(accountId);
        return repository.findIfAvailable(accountId);
    }
}
