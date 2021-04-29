package com.drinkio.drinkio.controller;

import com.drinkio.drinkio.dto.RecipeDTO;
import com.drinkio.drinkio.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/{drinkId}")
    public RecipeDTO getRecipe(@PathVariable("drinkId") Long drinkId) {
        return recipeService.getRecipe(drinkId);
    }
}
