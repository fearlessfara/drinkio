package com.drinkio.drinkio.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Drink drink;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Step> steps;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.DETACH, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<IngredientRecipe> ingredients = new HashSet<>();

    public Recipe() {
        //hibernatec
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Set<IngredientRecipe> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientRecipe> ingredientRecipes) {
        this.ingredients = ingredientRecipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return new EqualsBuilder().append(drink, recipe.drink).append(steps, recipe.steps).append(ingredients, recipe.ingredients).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(drink).append(steps).append(ingredients).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("drink", drink)
                .append("steps", steps)
                .append("ingredientRecipes", ingredients)
                .toString();
    }
}
