package com.drinkio.drinkio.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class IngredientRecipeId implements Serializable {

    @Column
    private Long ingredientId;

    @Column
    private Long recipeId;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        IngredientRecipeId that = (IngredientRecipeId) obj;
        return Objects.equals(ingredientId, that.ingredientId) && Objects.equals(recipeId, that.recipeId);
    }
}
