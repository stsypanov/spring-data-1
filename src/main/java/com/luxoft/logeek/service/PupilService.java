package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Pupil;
import com.luxoft.logeek.entity.Кореш;

public interface PupilService {
    void changeSchool(Long pupilId, String schoolName);

    Pupil подружиться(Long pupilId, Кореш кореш);
}
