package com.drinkio.drinkio.repository;

import com.drinkio.drinkio.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByDrink_Id(Long drinkId);
}
