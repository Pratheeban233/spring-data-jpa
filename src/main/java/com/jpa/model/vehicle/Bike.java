package com.jpa.model.vehicle;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {
	private boolean pillonSeatRequired;
	private boolean extraSpareRequired;
}
