package com.jpa.model.vehicle;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // TABLE_PER_CLASS only works on SEQUENCE
	private Long id;

	private String model;
	private String fuelType;
	private int mileage;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfManufactured;

	private int manufacturer_id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "manufacturer_id", insertable = false, updatable = false)
	private Manufacturer manufacturer;

}
