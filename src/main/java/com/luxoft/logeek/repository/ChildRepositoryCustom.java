package com.luxoft.logeek.repository;

import com.luxoft.logeek.entity.Child;

import java.util.Optional;

public interface ChildRepositoryCustom {

    Child findOldestOne();

    Optional<Child> _findOldestOne();
}
