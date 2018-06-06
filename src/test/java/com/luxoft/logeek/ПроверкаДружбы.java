package com.luxoft.logeek;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.entity.Друг;
import com.luxoft.logeek.service.PupilService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.transaction.AfterTransaction;

@Commit
@DatabaseSetup("/PupilServiceImplTest.xml")
public class ПроверкаДружбы extends TestBase {
    @Autowired
    private PupilService pupilService;

    @Test
    public void будемЛиДружить() {
        Друг друг = new Друг();
        pupilService.подружиться(1L, друг);
    }

    @AfterTransaction
    public void tearDown() {
        pupilRepository
                .findById(1L)
                .map(Ученик::лучшийДруг)
                .ifPresent(Assert::assertNotNull);
    }
}