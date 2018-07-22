package com.luxoft.logeek;

import com.luxoft.logeek.entity.Друг;
import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.repository.PupilRepository;
import com.luxoft.logeek.service.PupilService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.AfterTransaction;

import static org.junit.Assert.assertNotNull;

@Commit
@Sql("/PupilServiceImplTest.sql")
public class ПроверкаДружбы extends TestBase {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilRepository pupilRepository;

    @Test
    public void будемЛиДружить() {
        Ученик ученик = pupilService.подружиться(1L, new Друг());

        assertNotNull(ученик.лучшийДруг().getId());
    }

    @AfterTransaction
    public void tearDown() {
        pupilRepository
                .findById(1L)
                .map(Ученик::лучшийДруг)
                .ifPresent(Assert::assertNotNull);
    }
}