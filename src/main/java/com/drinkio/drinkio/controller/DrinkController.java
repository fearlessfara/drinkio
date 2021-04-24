package com.drinkio.drinkio.controller;

import com.drinkio.drinkio.dto.DrinkDTO;
import com.drinkio.drinkio.dto.SearchDTO;
import com.drinkio.drinkio.dto.SearchResultsDTO;
import com.drinkio.drinkio.helper.SearchHelper;
import com.drinkio.drinkio.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkController {



    @GetMapping("/{id}")
    public Drink getById(@RequestParam("id") Long id) {
        return null;
    }

}
