package com.luxoft.logeek.entity.jira729;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class BankAccount {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean available;

}