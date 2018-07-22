package com.luxoft.logeek.repository.datajpa729;

import com.luxoft.logeek.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.assertEquals;

@Sql("/BankAccountControlRepositoryTest.sql")
public class BankAccountRepositoryTest extends TestBase {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Test
    public void countByUserAccountId() {
        long count = bankAccountRepository.countByUserAccountId(1L);
        assertEquals(5, count);
    }

    @Test
    public void countByUserAccount_Id() {
        long count = bankAccountRepository.countByUserId(1L);
        assertEquals(5, count);
    }

    @Test
    public void countUserAccounts() {
        long count = bankAccountRepository.countUserAccounts(1L);
        assertEquals(5, count);
    }

}