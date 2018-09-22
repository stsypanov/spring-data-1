package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.entity.jira729.User;
import com.luxoft.logeek.exception.NPE;
import com.luxoft.logeek.repository.datajpa729.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository repo;

    @Override
    @Transactional
    public BankAccount updateRate(Long id, BigDecimal newRate) {
        BankAccount account = repo.findById(id).orElseThrow(NPE::new);
        account.setRate(newRate);
        return repo.save(account);
//        return account;
    }

    @Override
    @Transactional
    public BankAccount changeUser(Long id, User newUser) {
        BankAccount account = repo.findById(id).orElseThrow(NPE::new);
        account.setUser(newUser);
        return repo.save(account);
//        return account;
    }


}
