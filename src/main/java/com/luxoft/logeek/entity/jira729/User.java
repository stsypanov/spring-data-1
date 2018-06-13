package com.luxoft.logeek.entity.jira729;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    private Long id;
}