package com.luxoft.logeek.service.impl;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.service.BankAccountChecker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


@DatabaseSetup("/BankAccountControlRepositoryTest.xml")
public class BankAccountCheckerImplTest extends TestBase {
    @Autowired
    private BankAccountChecker bankAccountChecker;

    @Test
    public void checkAccount() {
        boolean годный = bankAccountChecker.checkAccount(5L);
        assertTrue(годный);
    }
}