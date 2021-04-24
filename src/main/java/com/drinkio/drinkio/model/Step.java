package com.drinkio.drinkio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Step {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;
}
