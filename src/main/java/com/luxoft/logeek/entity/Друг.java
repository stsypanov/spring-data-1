package com.luxoft.logeek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Друг {

    @Id
    @GeneratedValue
    private Long id;
}
