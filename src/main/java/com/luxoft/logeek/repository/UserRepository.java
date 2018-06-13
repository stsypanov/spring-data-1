package com.luxoft.logeek.repository;

import com.luxoft.logeek.entity.jira729.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.id in :ids")
    List<User> findAll(@Param("ids") Iterable<Long> ids);
}
