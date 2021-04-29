package com.drinkio.drinkio.repository;

import com.drinkio.drinkio.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findIngredientByNameLike(String searchTerm);
}
