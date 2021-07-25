package com.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.jpa.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dto.CourseRequestDto;
import com.jpa.model.City;
import com.jpa.model.Course;
import com.jpa.model.CourseContent;
import com.jpa.model.Employee;
import com.jpa.repository.CityRepository;
import com.jpa.repository.CourseContentRepository;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.EmployeeRepository;

@Service
public class ApplicationService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseContentRepository courseContentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<City> addCity(List<City> cities) {
		return cities.stream().map(city -> cityRepository.save(city)).collect(Collectors.toList());
	}

	public List<City> getCities() {
		return cityRepository.findAll();
	}

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

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee data deleted against the id #" + id;
	}

	public List<?> fetchAllEmployees(){
		return employeeRepository.findAll();
//		return employeeRepository.getAllEmployees();
	}
}
