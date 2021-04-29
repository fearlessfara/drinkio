package com.drinkio.drinkio.helper;

import com.drinkio.drinkio.dto.CategoryDTO;
import com.drinkio.drinkio.dto.DrinkDTO;
import com.drinkio.drinkio.dto.RecipeDTO;
import com.drinkio.drinkio.model.Category;
import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Recipe;
import com.drinkio.drinkio.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrinkHelper {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    CategoryHelper categoryHelper;

    @Autowired
    RecipeHelper recipeHelper;

    public DrinkDTO creatDrink(DrinkDTO drinkDTO) {
        return DrinkDTO.of(creatDrink(drinkDTO.name, drinkDTO.alcoholic, drinkDTO.categoryDTO, drinkDTO.recipeDTO));
    }

    public Drink creatDrink(String name, Boolean alcoholic, CategoryDTO categoryDTO, RecipeDTO recipeDTO) {
        Drink drink = new Drink();
        drink.setName(name);
        drink.setAlcoholic(alcoholic);

        Category category = categoryHelper.findOrCreateCategoryByName(categoryDTO.name);
        drink.setCategory(category);
        Recipe recipe = recipeHelper.createRecipe(recipeDTO, drink);
        drink.setRecipe(recipe);
        return saveOrUpdate(drink);
    }

    public Drink saveOrUpdate(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Boolean deleteDrink(Long drinkId) {
        drinkRepository.deleteById(drinkId);
        return true;
    }


}
