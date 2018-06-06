package com.luxoft.logeek.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Друг {

    @Id
    @GeneratedValue
    private Long id;
}
