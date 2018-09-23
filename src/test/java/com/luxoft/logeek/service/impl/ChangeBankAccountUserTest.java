package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.entity.jira729.User;
import com.luxoft.logeek.repository.BankAccountRepository;
import com.luxoft.logeek.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.AfterTransaction;

import static org.junit.Assert.assertNotNull;

@Commit
@Sql("/ChangeBankAccountUserTest.sql")
public class ChangeBankAccountUserTest extends TestBase {
    @Autowired
    private BankAccountService service;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Before
    public void setUp() {
        showUserName();
    }

    @Test
    public void changeUser() {
        User владимир = new User("Владимир");
        BankAccount bankAccount = service.changeUser(1L, владимир);

        assertNotNull(bankAccount.getUser().getId());
    }

    @AfterTransaction
    public void tearDown() {
        showUserName();
    }

    private void showUserName() {
        bankAccountRepository
                .findById(1L)
                .map(BankAccount::getUser)
                .map(User::getName)
                .ifPresent(System.out::println);
    }
}