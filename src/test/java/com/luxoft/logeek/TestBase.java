package com.luxoft.logeek;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.luxoft.logeek.repository.ChildRepository;
import com.luxoft.logeek.repository.ParentRepository;
import com.luxoft.logeek.repository.PupilRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "h2")
@TestExecutionListeners(value = {
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public abstract class TestBase {

}
