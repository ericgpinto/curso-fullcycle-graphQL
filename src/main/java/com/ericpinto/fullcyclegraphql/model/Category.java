package com.ericpinto.fullcyclegraphql.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    public static Category save(String name, String description) {
        Category category = new Category();
        category.id = UUID.randomUUID().toString();
        category.name = name;
        category.description = description;
        return category;
    }
}
