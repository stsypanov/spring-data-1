package com.luxoft.logeek.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ученик {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    public int возраст;

    @Column
    private String названиеШколы;

    @JoinColumn(name = "друг")
    @OneToOne(cascade = CascadeType.ALL)
    private Друг лучшийДруг;

    public void подружиться(Друг друг) {
        this.лучшийДруг = друг;
    }

    public void сменитьШколу(String названиеШколы) {
        this.названиеШколы = названиеШколы;
    }

    public String названиеШколы() {
        return названиеШколы;
    }

    public Друг лучшийДруг() {
        return лучшийДруг;
    }
}
