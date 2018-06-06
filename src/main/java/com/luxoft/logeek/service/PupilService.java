package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.entity.Друг;

public interface PupilService {
    void сменитьШколу(Long pupilId, String schoolName);

    Ученик подружиться(Long pupilId, Друг друг);
}
