package com.luxoft.logeek.repository;

import com.luxoft.logeek.entity.Child;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildRepository extends BaseJpaRepository<Child, Long>, ChildRepositoryCustom {

    @Query("select child from Child child " +
            "where child.parent.id in :ids")
    List<Child> findByParentIds(@Param("ids") Iterable<Long> ids);

    @Query("select child from Child child " +
            "where child.parent.name in :names")
    List<Child> findChildByParentName(@Param("names") Iterable<String> parentNames);

}
