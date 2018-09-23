package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.exception.NPE;
import com.luxoft.logeek.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional
@RequiredArgsConstructor
public class Modifier {
    private final BigDecimal value = BigDecimal.valueOf(0.01);
    private final BankAccountRepository repository;

    public BankAccount save(BankAccount account) {
        return repository.save(account);
    }

    public BankAccount addAndSave(Long pupilId) {
        BankAccount account = addOne(pupilId);
        return repository.save(account);
    }

    public BankAccount add(Long pupilId) {
        BankAccount account = addOne(pupilId);
        return account;
    }

    private BankAccount addOne(Long id) {
        BankAccount account = repository.findById(id).orElseThrow(NPE::new);
        account.setRate(account.getRate().add(value));
        return account;
    }

    public void clear() {
        repository.deleteAllInBatch();
    }
}
