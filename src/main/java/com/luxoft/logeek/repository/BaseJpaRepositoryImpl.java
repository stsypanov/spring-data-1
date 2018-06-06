package com.luxoft.logeek.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager entityManager;

    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else if (!entityManager.contains(entity)) {
            return entityManager.merge(entity);
        }

        return entity;
    }
}
