package com.jpa.dto;

import com.jpa.model.CourseContent;
import lombok.Data;

import java.util.Set;

@Data
public class CourseRequestDto {
	private Long id;
	private String courseName;
	private Set<CourseContent> courseContents;
}
