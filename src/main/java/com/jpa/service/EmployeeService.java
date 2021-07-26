package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.Employee;
import com.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee data deleted against the id # " + id;
	}

	public List<?> fetchAllEmployees(){
		return employeeRepository.findAll();
//		return employeeRepository.getAllEmployees();
	}

}
