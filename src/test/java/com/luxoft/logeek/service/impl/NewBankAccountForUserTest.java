package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.entity.Child;
import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.datajpa729.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.*;

@Sql("/NewBankAccountForUserTest.sql")
public class NewBankAccountForUserTest extends TestBase {
    @Autowired
    private BankAccountService service;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void newForUser() {
        service.newForUser(1L);
    }

    @After
    public void tearDown() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        assertNotNull(bankAccounts.get(0).getUser());
    }
}