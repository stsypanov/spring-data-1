package com.luxoft.logeek.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pupil {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    public int age;

    @Column
    private String schoolName;

    @JoinColumn(name = "кореш")
    @ManyToOne(cascade = CascadeType.ALL)
    private Кореш кореш;

    public void подружиться(Кореш кореш) {
        this.кореш = кореш;
    }
}
