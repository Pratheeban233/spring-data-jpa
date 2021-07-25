package com.jpa.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
	@SequenceGenerator(name = "seq_employee", allocationSize = 1, sequenceName = "employee_sequence")
	@Column(name = "id")
	private Long employeeId;

	@NotNull(message = "Employee name is required")
	@NotEmpty(message = "Employee name should not be blank")
	@Size(min = 10, max = 50, message = "Employee Name should be between 10 - 50")
	@Pattern(regexp = "^[a-zA-Z ]*$",message = "Employee Name allows only Alphabetic")
	@Column(name = "employee_name", columnDefinition = "character varying(50) not null")
	private String employeeName;

	@NotNull(message = "Age is required")
	@Min(value = 18, message = "Age should be above 18")
	@Column(name = "age", columnDefinition = "int8 not null")
	private Long age;
}
