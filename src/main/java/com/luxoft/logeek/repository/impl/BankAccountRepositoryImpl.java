package com.luxoft.logeek.repository.impl;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.BankAccountRepositoryCustom;
import org.hibernate.Session;

import java.util.Optional;

public class BankAccountRepositoryImpl extends BaseDao implements BankAccountRepositoryCustom {

    @Override
    public Optional<BankAccount> findWithHighestRate() {
        String query = "select b from BankAccount b order by b.rate";
        BankAccount bankAccount = em.unwrap(Session.class).createQuery(query, BankAccount.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();
        return Optional.of(bankAccount);
    }
}
