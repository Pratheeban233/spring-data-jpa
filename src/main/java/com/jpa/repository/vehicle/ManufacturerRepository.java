package com.jpa.repository.vehicle;

import com.jpa.model.vehicle.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
