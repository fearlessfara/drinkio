package com.drinkio.drinkio.helper;

import com.drinkio.drinkio.model.Category;
import com.drinkio.drinkio.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategoryHelper {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findOrCreateCategoryByName(String categoryName) {
        Category category;
        try {
            category = findCategoryByName(categoryName);
        } catch (RuntimeException ex) {
            log.info("Category {} not found, creating it", categoryName);
            category = new Category();
            category.setName(categoryName);
            categoryRepository.save(category);
        }
        return category;
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName).orElseThrow(() -> new RuntimeException("category not found"));
    }
}
