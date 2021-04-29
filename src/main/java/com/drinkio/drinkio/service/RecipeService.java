package com.drinkio.drinkio.service;

import com.drinkio.drinkio.core.Preconditions;
import com.drinkio.drinkio.dto.RecipeDTO;
import com.drinkio.drinkio.helper.RecipeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RecipeService {

    @Autowired
    RecipeHelper recipeHelper;

    public RecipeDTO getRecipe(@PathVariable("drinkId") Long drinkId) {
        Preconditions.checkArgument(drinkId != null, IllegalArgumentException.class, "IDs cannot be null");
        return recipeHelper.findByDrinkId(drinkId);
    }

}
