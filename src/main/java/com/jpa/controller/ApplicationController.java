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
import com.jpa.model.Doctor;
import com.jpa.model.Employee;
import com.jpa.model.Patient;
import com.jpa.service.CityService;
import com.jpa.service.CourseService;
import com.jpa.service.DoctorPatientService;
import com.jpa.service.EmployeeService;

@RestController
@Validated
public class ApplicationController {

	@Autowired
	private CityService cityService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DoctorPatientService doctorPatientService;

	@PostMapping("/add-city")
	public ResponseEntity<Object> saveCity(@RequestBody List<City> cities) {
		return new ResponseEntity<>(cityService.addCity(cities), HttpStatus.OK);
	}

	@GetMapping("/get-cities")
	public ResponseEntity<Object> getCities() {
		return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
	}

	@PostMapping("/add-course")
	public ResponseEntity<Object> addCourse(@RequestBody CourseRequestDto courseRequestDto) {
		return new ResponseEntity<>(courseService.addCourse(courseRequestDto), HttpStatus.OK);
	}

	@PostMapping("/add-employee")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
	}

	@GetMapping("get-employees")
	public ResponseEntity<Object> getAllEmployees() {
		return ResponseEntity.ok(employeeService.fetchAllEmployees());
	}

	@DeleteMapping("/delete-employee")
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") @Min(value = 1, message = "Employee id should be greater than 0/zero") Long id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}

	@PostMapping("/add-doctor")
	public ResponseEntity<Object> addDoctor(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorPatientService.addDoctor(doctor));
	}

	@PostMapping("/add-patient")
	public ResponseEntity<Object> addPatient(@RequestBody Patient patient) {
		return ResponseEntity.ok(doctorPatientService.addPatient(patient));
	}
}
