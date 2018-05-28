package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Кореш;
import com.luxoft.logeek.repository.PupilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class PupilServiceImpl implements PupilService {
    private final PupilRepository pupilRepository;

    @Override
    public void changeSchool(Long pupilId, String schoolName) {
        pupilRepository.findById(pupilId).ifPresent(pupil -> {
            pupil.setSchoolName(schoolName);
            pupilRepository.save(pupil);
        });
    }

    @Override
    public void подружиться(Long pupilId, Кореш кореш) {
        pupilRepository.findById(pupilId).ifPresent(pupil -> {
            pupil.подружиться(кореш);
            pupilRepository.save(pupil);
        });
    }


}
