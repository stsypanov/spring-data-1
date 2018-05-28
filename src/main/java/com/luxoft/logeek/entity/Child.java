package com.luxoft.logeek.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Parent parent;

    @Column
    private short age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    private List<Toy> toys = new ArrayList<>();

    public Child() {
    }

}
