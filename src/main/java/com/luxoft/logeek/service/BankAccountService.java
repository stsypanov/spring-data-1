package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.jira729.BankAccount;

import java.math.BigDecimal;

public interface BankAccountService {

    BankAccount updateRate(Long accountId, BigDecimal newRate);
}
