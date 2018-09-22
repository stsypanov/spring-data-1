package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.entity.jira729.User;

import java.math.BigDecimal;

public interface BankAccountService {

    BankAccount updateRate(Long accountId, BigDecimal newRate);

    BankAccount changeUser(Long accountId, User newOwner);
}
