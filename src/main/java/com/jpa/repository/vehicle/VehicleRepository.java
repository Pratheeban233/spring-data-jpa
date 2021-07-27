package com.jpa.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
