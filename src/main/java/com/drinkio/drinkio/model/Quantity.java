package com.drinkio.drinkio.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Quantity {

    public enum Unit {ml, oz, liters}

    @Enumerated(value = EnumType.STRING)
    private Unit unit;

    private Number amount;

    public Quantity() {

    }
}
