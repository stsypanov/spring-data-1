package com.luxoft.logeek.repository;

import com.luxoft.logeek.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class UserRepositoryTest extends TestBase {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll() {
        userRepository.findAll(Collections.emptyList());
    }
}