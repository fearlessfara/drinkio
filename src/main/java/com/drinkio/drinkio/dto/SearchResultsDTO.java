package com.drinkio.drinkio.dto;

import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Ingredient;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsDTO {

    public List<Drink> drinks;
    public List<Ingredient> ingredients;

    public SearchResultsDTO(){

    }

    public SearchResultsDTO(Drink drink) {
        this.drinks = Collections.singletonList(drink);
    }

    public SearchResultsDTO(Ingredient ingredient) {
        this.ingredients = Collections.singletonList(ingredient);
    }

    public static SearchResultsDTO ofIngredients(List<Ingredient> ingredients){
        SearchResultsDTO dto = new SearchResultsDTO();
        dto.ingredients = ingredients;
        return dto;
    }

    public static SearchResultsDTO ofDrinks(List<Drink> drinks){
        SearchResultsDTO dto = new SearchResultsDTO();
        dto.drinks = drinks;
        return dto;
    }
}
