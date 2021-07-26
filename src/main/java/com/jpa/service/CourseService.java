package com.jpa.service;

import com.jpa.dto.CourseRequestDto;
import com.jpa.model.Course;
import com.jpa.model.CourseContent;
import com.jpa.repository.CourseContentRepository;
import com.jpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseContentRepository courseContentRepository;

	public Course addCourse(CourseRequestDto courseRequestDto) {
		Course course = new Course();
		course.setCourseId(courseRequestDto.getId());
		course.setCourseName(courseRequestDto.getCourseName());
		course.setCourseContents(courseRequestDto.getCourseContents().stream().map(courseContent -> {
			CourseContent ccontents = courseContent;
			if (ccontents.getCourseContentId() > 0) {
				ccontents = courseContentRepository.findById(courseContent.getCourseContentId()).get();
			}
			ccontents.addCourse(course);
			return ccontents;
		}).collect(Collectors.toSet()));
		return courseRepository.save(course);
	}
}
