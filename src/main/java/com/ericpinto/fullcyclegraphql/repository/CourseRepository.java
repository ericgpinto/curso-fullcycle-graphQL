package com.ericpinto.fullcyclegraphql.repository;

import com.ericpinto.fullcyclegraphql.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByCategoryId(String categoryId);
}
