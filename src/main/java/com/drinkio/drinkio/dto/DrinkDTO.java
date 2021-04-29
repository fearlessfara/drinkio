package com.drinkio.drinkio.dto;

import com.drinkio.drinkio.model.Drink;

import java.util.Objects;

public class DrinkDTO {


    public String name;
    public Long id;
    public RecipeDTO recipeDTO;
    public Boolean alcoholic;
    public CategoryDTO categoryDTO;

    public static DrinkDTO of(Drink drink) {
        if (Objects.isNull(drink)) {
            return new DrinkDTO();
        }
        DrinkDTO dto = new DrinkDTO();
        dto.name = drink.getName();
        dto.id = drink.getId();
        dto.recipeDTO = RecipeDTO.of(drink.getRecipe());
        return dto;
    }
}
