package com.drinkio.drinkio.service;

import com.drinkio.drinkio.dto.SearchDTO;
import com.drinkio.drinkio.dto.SearchResultsDTO;
import com.drinkio.drinkio.helper.SearchHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    SearchHelper searchHelper;

    public SearchResultsDTO search(SearchDTO searchDTO) {
        return searchHelper.search(searchDTO);
    }

    public SearchResultsDTO searchIngredients(SearchDTO searchDTO) {
        return searchHelper.searchIngredients(searchDTO);
    }
}
