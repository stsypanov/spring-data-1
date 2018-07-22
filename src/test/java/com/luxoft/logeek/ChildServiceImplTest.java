package com.luxoft.logeek;

import com.luxoft.logeek.entity.Child;
import com.luxoft.logeek.repository.ChildRepository;
import com.luxoft.logeek.service.ChildService;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Сергей on 02.04.2017.
 */
@Sql("/ChildServiceImplTest.sql")
public class ChildServiceImplTest extends TestBase {
    @Autowired
    private ChildService childService;
    @Autowired
    private ChildRepository childRepository;

    @Test
    public void newChildForParent() {
        childService.newChildForParent(1L);
    }

    @After
    public void tearDown() {
        List<Child> children = childRepository.findAll();
        assertNotNull(children.get(0).getParent());
    }
}