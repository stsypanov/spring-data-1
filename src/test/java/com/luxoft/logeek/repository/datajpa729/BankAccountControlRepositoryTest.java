package com.luxoft.logeek.repository.datajpa729;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@DatabaseSetup("/BankAccountControlRepositoryTest.xml")
public class BankAccountControlRepositoryTest extends TestBase {
    @Autowired
    BankAccountControlRepository bankAccountControlRepository;
    private Long count1;
    private Long count2;
    private Long count3;

    @Test
    public void countByUserAccountId() {
        count1 = bankAccountControlRepository.countByUserAccountId(1L);
    }

    @Test
    public void countByUserAccount_Id() {
        count2 = bankAccountControlRepository.countByUserAccount_Id(1L);
    }

    @Test
    public void countUserAccounts() {
        count3 = bankAccountControlRepository.countUserAccounts(1L);
    }

    @After
    public void tearDown() {
        if (count1 != null && count2 != null && count3 != null) {
            assertEquals(count1, count2);
        }
    }
}