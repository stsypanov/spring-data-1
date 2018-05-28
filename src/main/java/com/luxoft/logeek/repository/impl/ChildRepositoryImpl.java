package com.luxoft.logeek.repository.impl;

import com.luxoft.logeek.entity.Child;
import com.luxoft.logeek.repository.ChildRepositoryCustom;
import org.hibernate.Session;

import java.util.Optional;

public class ChildRepositoryImpl extends BaseDao implements ChildRepositoryCustom {

    @Override
    public Child findOldestOne() {
        String queryString = "select c from Child c order by c.age";
        return em.createQuery(queryString, Child.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public Optional<Child> _findOldestOne() {
        String queryString = "select c from Child c order by c.age";
        return em.unwrap(Session.class)
                .createQuery(queryString, Child.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

}
