package com.luxoft.logeek;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.repository.PupilRepository;
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
    private final String новаяШкола = "ООШ №3";

    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilRepository pupilRepository;

    @Before
    public void проверкаДо() {
        pupilRepository.findById(1L).map(Ученик::названиеШколы).ifPresent(this::вывестиШколу);
    }

    @Test
    public void сменитьШколу() {
        pupilService.сменитьШколу(1L, новаяШкола);
    }

    @AfterTransaction
    public void проверкаПосле() {
        pupilRepository.findById(1L).map(Ученик::названиеШколы)
                .ifPresent(школа -> {
                    assertEquals(новаяШкола, школа);
                    вывестиШколу(школа);
                });
    }

    private void вывестиШколу(String школа) {
        System.out.println("Моя школа: " + школа);
    }
}