package com.drinkio.drinkio.service;

import com.drinkio.drinkio.core.Preconditions;
import com.drinkio.drinkio.dto.DrinkDTO;
import com.drinkio.drinkio.helper.DrinkHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

    @Autowired
    DrinkHelper drinkHelper;

    public DrinkDTO createDrink(DrinkDTO drinkDTO) {
        Preconditions.checkArgument(drinkDTO.name, "Drink name cannot be null");
        return drinkHelper.createDrink(drinkDTO);
    }

    public DrinkDTO getById(Long id) {
        return drinkHelper.getById(id);
    }
}
