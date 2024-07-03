package com.ericpinto.fullcyclegraphql.model;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.util.UUID;

@Entity(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String categoryId;

    public static Course save(String name, String description, String categoryId) {
        Course course = new Course();
        course.id = UUID.randomUUID().toString();
        course.name = name;
        course.description = description;
        course.categoryId = categoryId;
        return course;
    }
}
