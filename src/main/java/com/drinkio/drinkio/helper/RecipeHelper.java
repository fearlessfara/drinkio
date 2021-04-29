package com.drinkio.drinkio.helper;

import com.drinkio.drinkio.dto.RecipeDTO;
import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Recipe;
import com.drinkio.drinkio.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeHelper {

    @Autowired
    RecipeRepository recipeRepository;


    public RecipeDTO findByDrinkId(Long drinkId) {
        return RecipeDTO.of(recipeRepository.findByDrink_Id(drinkId).orElseThrow(IllegalArgumentException::new));
    }

    public Recipe createRecipe(RecipeDTO recipeDTO, Drink drink) {
        Recipe recipe = new Recipe();
        recipe.setDrink(drink);

        return saveOrUpdate(recipe);
    }


    public Recipe saveOrUpdate(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
