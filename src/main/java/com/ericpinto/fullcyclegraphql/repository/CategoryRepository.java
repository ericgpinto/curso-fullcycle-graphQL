package com.ericpinto.fullcyclegraphql.repository;

import com.ericpinto.fullcyclegraphql.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
