package com.drinkio.drinkio.helper;

import com.drinkio.drinkio.dto.SearchDTO;
import com.drinkio.drinkio.dto.SearchResultsDTO;
import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Recipe;
import com.drinkio.drinkio.repository.DrinkRepository;
import com.drinkio.drinkio.repository.IngredientRepository;
import com.drinkio.drinkio.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class SearchHelper {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public SearchResultsDTO searchDrinkByName(SearchDTO searchDTO) {
        var searchTerm = "%" + searchDTO.name + "%";
        return SearchResultsDTO.ofDrinks(drinkRepository.findDrinksByNameLike(searchTerm));
    }

    public SearchResultsDTO searchDrinkByIngredients(SearchDTO searchDTO) {
        List<Recipe> recipes = recipeRepository.findRecipeByIngredientsIn(searchDTO.ingredients);
        List<Drink> drinks = drinkRepository.findDrinksByRecipeIn(recipes);
        return SearchResultsDTO.ofDrinks(drinks);
    }

    public SearchResultsDTO searchIngredients(SearchDTO searchDTO) {
        var searchTerm = "%" + searchDTO.ingredient + "%";
        return SearchResultsDTO.ofIngredients(ingredientRepository.findIngredientByNameLike(searchTerm));
    }

    public SearchResultsDTO search(SearchDTO searchDTO) {
        if (Objects.nonNull(searchDTO.name)) {
            return searchDrinkByName(searchDTO);
        }
        return searchDrinkByIngredients(searchDTO);
    }
}
