package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
