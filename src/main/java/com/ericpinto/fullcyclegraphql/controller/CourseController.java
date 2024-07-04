package com.ericpinto.fullcyclegraphql.controller;

import com.ericpinto.fullcyclegraphql.model.Category;
import com.ericpinto.fullcyclegraphql.model.Course;
import com.ericpinto.fullcyclegraphql.model.input.NewCategory;
import com.ericpinto.fullcyclegraphql.model.input.NewCourse;
import com.ericpinto.fullcyclegraphql.repository.CategoryRepository;
import com.ericpinto.fullcyclegraphql.repository.CourseRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseController(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping
    public List<Course> courses(){
        return courseRepository.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument NewCourse input) {
        Category category = categoryRepository.findById(input.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Course course = Course.save(input.name(), input.description(), category);
        return courseRepository.save(course);
    }


}
