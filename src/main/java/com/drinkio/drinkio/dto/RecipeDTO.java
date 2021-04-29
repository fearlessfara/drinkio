package com.drinkio.drinkio.dto;

import com.drinkio.drinkio.model.Ingredient;
import com.drinkio.drinkio.model.Recipe;
import com.drinkio.drinkio.model.Step;

import java.util.List;

public class RecipeDTO {

    public Long id;

    public List<Ingredient> ingredients;

    public List<Step> steps;


    public static RecipeDTO of(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.id = recipe.getId();
        recipeDTO.ingredients = recipe.getIngredients();
        recipeDTO.steps = recipe.getSteps();
        return recipeDTO;
    }
}
