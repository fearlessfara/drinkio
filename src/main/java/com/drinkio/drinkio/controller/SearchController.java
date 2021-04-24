package com.drinkio.drinkio.controller;

import com.drinkio.drinkio.dto.SearchDTO;
import com.drinkio.drinkio.dto.SearchResultsDTO;
import com.drinkio.drinkio.helper.SearchHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    SearchHelper searchHelper;

    @PostMapping("/search")
    public SearchResultsDTO search(@RequestBody SearchDTO searchDTO) {
        return searchHelper.search(searchDTO);
    }

    @PostMapping("/searchIngredients")
    public SearchResultsDTO searchIngredient(@RequestBody SearchDTO searchDTO) {
        return searchHelper.searchIngredients(searchDTO);
    }
}
