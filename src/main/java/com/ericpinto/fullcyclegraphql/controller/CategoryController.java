package com.ericpinto.fullcyclegraphql.controller;

import com.ericpinto.fullcyclegraphql.model.Category;
import com.ericpinto.fullcyclegraphql.model.input.NewCategory;
import com.ericpinto.fullcyclegraphql.repository.CategoryRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @MutationMapping
    public Category createCategory(@Argument NewCategory input) {
        Category category = Category.save(input.name(), input.description());
        return categoryRepository.save(category);
    }


}
