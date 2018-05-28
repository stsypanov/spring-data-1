package com.luxoft.logeek.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import com.luxoft.logeek.entity.Pupil;
import com.luxoft.logeek.entity.Кореш;
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
        Кореш кореш = new Кореш();
        pupilService.подружиться(1L, кореш);
    }

    @AfterTransaction
    public void tearDown() {
        pupilRepository
                .findById(1L)
                .map(Pupil::getКореш)
                .ifPresent(Assert::assertNotNull);
    }
}