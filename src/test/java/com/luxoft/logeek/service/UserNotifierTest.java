package com.luxoft.logeek.service;

import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.dto.UserNotifierDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.assertEquals;

@Sql("/UserNotifierTest.sql")
public class UserNotifierTest extends TestBase {
    @Autowired
    UserNotifier notifier;

    @Test
    public void useUsers() {
        UserNotifierDto dto = new UserNotifierDto(1L, 2L);
        long count = notifier.countUsers(dto, 1L);

        assertEquals(count, 1);
    }
}