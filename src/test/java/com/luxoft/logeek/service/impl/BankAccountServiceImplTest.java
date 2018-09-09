package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.datajpa729.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.AfterTransaction;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@Commit
@Sql("/BankAccountServiceImplTest.sql")
public class BankAccountServiceImplTest extends TestBase {
    private BigDecimal newRate = BigDecimal.valueOf(0.15);

    @Autowired
    private BankAccountService service;
    @Autowired
    private BankAccountRepository repository;

    @Before
    public void setUp() {
        repository.findById(1L).map(BankAccount::getRate).ifPresent(System.out::println);
    }

    @Test
    public void updateRate() {
        service.updateRate(1L, newRate);
    }

    @AfterTransaction
    public void проверкаПосле() {
        repository.findById(1L).map(BankAccount::getRate)
                .ifPresent(rate -> {
                    assertEquals(newRate, rate);
                    System.out.println(rate);
                });
    }
}