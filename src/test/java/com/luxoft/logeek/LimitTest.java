package com.luxoft.logeek;

import com.luxoft.logeek.repository.ChildRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ActiveProfiles(profiles = "postgres")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class LimitTest {
    @Autowired
    ChildRepository childRepository;

    @Test
    public void findOldestOne() {
        childRepository.findOldestOne();
    }

    @Test
    public void _findOldestOne() {
        childRepository._findOldestOne();
    }

    @Test
    public void findOldestOne_() {
        childRepository.findOldestOne();
    }
}
