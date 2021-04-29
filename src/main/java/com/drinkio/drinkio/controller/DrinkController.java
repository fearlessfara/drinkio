package com.drinkio.drinkio.controller;

import com.drinkio.drinkio.dto.DrinkDTO;
import com.drinkio.drinkio.helper.DrinkHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    DrinkHelper drinkHelper;


    @GetMapping("/{id}")
    public DrinkDTO getById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/createDrink")
    public DrinkDTO createDrink(@RequestBody DrinkDTO drinkDTO) {
        return drinkHelper.creatDrink(drinkDTO);
    }

}
