package com.luxoft.logeek.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {

    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInfo, EntityManager entityManager) {
        super(entityInfo, entityManager);
    }

    @Override
    public <S extends T> S save(S entity) {
        return super.save(entity);
    }
}
