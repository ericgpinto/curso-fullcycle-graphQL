package com.ericpinto.fullcyclegraphql.controller;

import com.ericpinto.fullcyclegraphql.model.Category;
import com.ericpinto.fullcyclegraphql.model.Course;
import com.ericpinto.fullcyclegraphql.model.input.NewCategory;
import com.ericpinto.fullcyclegraphql.repository.CategoryRepository;
import com.ericpinto.fullcyclegraphql.repository.CourseRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;

    public CategoryController(CategoryRepository categoryRepository, CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;

    }

    @QueryMapping
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @SchemaMapping()
    public List<Course> courses(Category category){
        return courseRepository.findByCategoryId(category.getId());
    }

    @QueryMapping
    public Category categoryById(@Argument("id") String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @MutationMapping
    public Category createCategory(@Argument NewCategory input) {
        Category category = Category.save(input.name(), input.description());
        return categoryRepository.save(category);
    }


}
