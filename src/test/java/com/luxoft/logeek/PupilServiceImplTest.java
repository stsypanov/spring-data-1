package com.luxoft.logeek;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.service.PupilService;
import org.junit.Before;
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

    @Before
    public void setUp() {
        pupilRepository.findById(1L)
                .map(Ученик::названиеШколы)
                .ifPresent(this::вывестиШколу);
    }

    @Test
    public void changeSchool() {
        pupilService.сменитьШколу(1L, "ООШ №3");
    }

    @AfterTransaction
    public void tearDown() {
        pupilRepository.findById(1L).map(Ученик::названиеШколы)
                .ifPresent(школа -> {
                    assertEquals("ООШ №3", школа);
                    вывестиШколу(школа);
                });
    }

    private void вывестиШколу(String школа) {
        System.out.println("Моя школа: " + школа);
    }
}