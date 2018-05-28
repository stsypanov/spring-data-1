package com.luxoft.logeek.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.transaction.AfterTransaction;

import static org.junit.Assert.assertEquals;

@Commit
@DatabaseSetup("/PupilServiceImplTest.xml")
public class PupilServiceImplTest extends TestBase {
    @Autowired
    private PupilService pupilService;

    @Test
    public void changeSchool() {
        pupilRepository
                .findById(1L)
                .ifPresent(pupil -> System.out.println("Моя старая школа: " + pupil.getSchoolName()));
        pupilService.changeSchool(1L, "ООШ №3");
    }

    @AfterTransaction
    public void tearDown() {
        pupilRepository
                .findById(1L)
                .ifPresent(pupil -> {
                    assertEquals("ООШ №3", pupil.getSchoolName());
                    System.out.println("Моя новая школа: " + pupil.getSchoolName());
                });
    }
}