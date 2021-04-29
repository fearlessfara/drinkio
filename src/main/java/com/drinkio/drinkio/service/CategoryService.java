package com.drinkio.drinkio.service;

import com.drinkio.drinkio.helper.CategoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    CategoryHelper categoryHelper;
}
