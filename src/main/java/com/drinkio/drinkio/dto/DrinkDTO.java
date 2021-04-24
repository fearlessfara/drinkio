package com.drinkio.drinkio.dto;

import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Ingredient;
import com.drinkio.drinkio.model.Recipe;

import java.util.List;
import java.util.Objects;

public class DrinkDTO {


    private String name;
    private Long id;
    private List<Ingredient> ingredients;
    private Recipe recipe;

    public static DrinkDTO of(Drink drink){
        if(Objects.isNull(drink)){
            return new DrinkDTO();
        }
        DrinkDTO dto = new DrinkDTO();
        dto.name = drink.getName();
        dto.id = drink.getId();
        dto.recipe = drink.getRecipe();
        return dto;
    }
}
