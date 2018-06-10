package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.entity.Друг;

public interface PupilService {
    void сменитьШколу(Long номер, String наваниеШколы);

    Ученик подружиться(Long номер, Друг друг);
}
