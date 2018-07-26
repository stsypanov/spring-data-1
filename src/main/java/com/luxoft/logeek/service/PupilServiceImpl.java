package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Друг;
import com.luxoft.logeek.entity.Ученик;
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
    public Ученик сменитьШколу(Long номер, String наваниеШколы) {
        Ученик ученик = repository.findById(номер).orElseThrow(NullPointerException::new);
        ученик.сменитьШколу(наваниеШколы);
        return repository.save(ученик);
    }

    @Override
    public Ученик подружиться(Long номер, Друг друг) {
        Ученик ученик = repository.findById(номер).orElseThrow(NullPointerException::new);
        ученик.подружиться(друг);
        return repository.save(ученик);
    }

}
