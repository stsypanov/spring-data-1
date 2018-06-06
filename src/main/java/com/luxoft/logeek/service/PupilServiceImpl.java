package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.entity.Друг;
import com.luxoft.logeek.repository.PupilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class PupilServiceImpl implements PupilService {
    private final PupilRepository repository;

    @Override
    public void сменитьШколу(Long pupilId, String названиеШколы) {
        repository.findById(pupilId).ifPresent(ученик -> {
            ученик.сменитьШколу(названиеШколы);
            repository.save(ученик);
        });
    }

    @Override
    @Transactional
    public Ученик подружиться(Long pupilId, Друг друг) {
        Ученик ученик = repository.findById(pupilId).orElseThrow(NullPointerException::new);
        ученик.подружиться(друг);
        return repository.save(ученик);
    }


}
