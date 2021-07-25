package com.jpa.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jpa.dto.CourseRequestDto;
import com.jpa.model.City;
import com.jpa.model.Employee;
import com.jpa.service.ApplicationService;

@RestController
@Validated
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/add-city")
	public ResponseEntity<Object> saveCity(@RequestBody List<City> cities) {
		return new ResponseEntity<>(applicationService.addCity(cities), HttpStatus.OK);
	}

	@GetMapping("/get-cities")
	public ResponseEntity<Object> getCities() {
		return new ResponseEntity<>(applicationService.getCities(), HttpStatus.OK);
	}

	@PostMapping("/add-course")
	public ResponseEntity<Object> addCourse(@RequestBody CourseRequestDto courseRequestDto) {
		return new ResponseEntity<>(applicationService.addCourse(courseRequestDto), HttpStatus.OK);
	}

	@PostMapping("/add-employee")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(applicationService.saveEmployee(employee), HttpStatus.OK);
	}

	@GetMapping("get-employees")
	public ResponseEntity<Object> getAllEmployees() {
		return ResponseEntity.ok(applicationService.fetchAllEmployees());
	}

	@DeleteMapping("/delete-employee")
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") @Min(value = 1, message = "Employee id should be greater than 0/zero") Long id) {
		return ResponseEntity.ok(applicationService.deleteEmployee(id));
	}

}
