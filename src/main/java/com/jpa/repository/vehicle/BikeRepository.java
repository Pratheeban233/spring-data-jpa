package com.jpa.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.vehicle.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
