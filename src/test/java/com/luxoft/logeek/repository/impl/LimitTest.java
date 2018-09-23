package com.luxoft.logeek.repository.impl;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.BankAccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "h2")
public class LimitTest {
    @Autowired
    private BankAccountRepository repository;

    @Test
    public void findOneWithHighestRate() {
        repository.findWithHighestRate();
    }
}