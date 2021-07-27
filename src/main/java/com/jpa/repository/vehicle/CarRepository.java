package com.jpa.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.vehicle.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
