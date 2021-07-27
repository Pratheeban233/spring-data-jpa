package com.jpa.model.vehicle;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Car extends Vehicle{

	private int seatingCapacity;
	private boolean sunRoof;

}
