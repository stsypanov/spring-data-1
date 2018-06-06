package com.luxoft.logeek.service.impl;

import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.repository.PupilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class Modifier {
    private final PupilRepository repository;

    public Ученик save(Ученик ученик) {
        return repository.save(ученик);
    }

    public Ученик накинутьГодИСохранить(Long pupilId) {
        Ученик ученик = добавить(pupilId);
        return repository.save(ученик);
    }

    public Ученик накинутьГод(Long pupilId) {
        Ученик ученик = добавить(pupilId);
        return ученик;
    }

    private Ученик добавить(Long pupilId) {
        Ученик ученик = repository.findById(pupilId).orElseThrow(NullPointerException::new);
        ученик.возраст++;
        return ученик;
    }
}
