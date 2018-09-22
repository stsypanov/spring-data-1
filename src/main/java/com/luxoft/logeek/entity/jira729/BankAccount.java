package com.luxoft.logeek.entity.jira729;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
public class BankAccount {
    @Id
    @GeneratedValue
    private long id;

    @Column
    @Setter
    private BigDecimal rate = BigDecimal.ZERO;

    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Column
    private boolean available;

}