package com.luxoft.logeek.repository.datajpa729;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@DatabaseSetup("/BankAccountControlRepositoryTest.xml")
public class BankAccountRepositoryTest extends TestBase {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Test
    public void countByUserAccountId() {
        long count = bankAccountRepository.countByUserAccountId(1L);
        assertEquals(4, count);
    }

    @Test
    public void countByUserAccount_Id() {
        long count = bankAccountRepository.countByUserId(1L);
        assertEquals(4, count);
    }

    @Test
    public void countUserAccounts() {
        long count = bankAccountRepository.countUserAccounts(1L);
        assertEquals(4, count);
    }

}