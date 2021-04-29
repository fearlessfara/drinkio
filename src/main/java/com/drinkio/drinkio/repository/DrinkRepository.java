package com.drinkio.drinkio.repository;

import com.drinkio.drinkio.model.Drink;
import com.drinkio.drinkio.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    List<Drink> findDrinksByNameLike(String searchTerm);

    List<Drink> findDrinksByRecipeIn(List<Recipe> recipes);
}
