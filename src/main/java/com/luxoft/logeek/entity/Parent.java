package com.luxoft.logeek.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    protected Parent() {
    }

}
