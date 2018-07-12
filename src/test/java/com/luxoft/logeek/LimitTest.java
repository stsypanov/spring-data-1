package com.luxoft.logeek;

import com.luxoft.logeek.entity.Child;
import com.luxoft.logeek.repository.ChildRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "h2")
public class LimitTest {
    @Autowired
    ChildRepository childRepository;

    @Test
    public void findOldestOne() {
        childRepository.findOldestOne();
    }

    @Test
    public void _findOldestOne() {
        Optional<Child> optional = childRepository._findOldestOne();
        assertFalse(optional.isPresent());
    }

}
