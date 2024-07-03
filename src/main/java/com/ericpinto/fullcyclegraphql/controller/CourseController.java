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

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @QueryMapping
    public List<Course> courses(){
        return courseRepository.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument NewCourse input) {
        Course course = Course.save(input.name(), input.description(), input.categoryId());
        return courseRepository.save(course);
    }


}
