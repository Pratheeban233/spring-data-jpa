package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.CourseContent;

public interface CourseContentRepository extends JpaRepository<CourseContent, Long> {
}
