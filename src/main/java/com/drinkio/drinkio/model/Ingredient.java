package com.drinkio.drinkio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String quantity;
}
