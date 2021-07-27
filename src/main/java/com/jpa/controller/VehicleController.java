package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.vehicle.Bike;
import com.jpa.model.vehicle.Car;
import com.jpa.model.vehicle.Manufacturer;
import com.jpa.model.vehicle.Vehicle;
import com.jpa.repository.vehicle.BikeRepository;
import com.jpa.repository.vehicle.CarRepository;
import com.jpa.repository.vehicle.ManufacturerRepository;
import com.jpa.repository.vehicle.VehicleRepository;

@RestController
public class VehicleController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private BikeRepository bikeRepository;

	@PostMapping("/addmanufature")
	public ResponseEntity<Object> addManufacturer(@RequestBody List<Manufacturer> manufacturers) {
		return ResponseEntity.ok(manufacturerRepository.saveAll(manufacturers));
	}

	@PostMapping("/addvehicle")
	public ResponseEntity<Object> addVehicle(@RequestBody List<Vehicle> vehicles) {
		return ResponseEntity.ok(vehicleRepository.saveAll(vehicles));
	}

	@PostMapping("/addcar")
	public ResponseEntity<Object> addCar(@RequestBody List<Car> cars) {
		return ResponseEntity.ok(carRepository.saveAll(cars));
	}

	@PostMapping("/addbike")
	public ResponseEntity<Object> addBike(@RequestBody List<Bike> bikes) {
		return ResponseEntity.ok(bikeRepository.saveAll(bikes));
	}

	@GetMapping("/getvehicles")
	public ResponseEntity<Object> getVehicle() {
		return ResponseEntity.ok(vehicleRepository.findAll());
	}

	@GetMapping("/getmanufacturers")
	public ResponseEntity<Object> getManufacturer() {
		return ResponseEntity.ok(manufacturerRepository.findAll());
	}

	@GetMapping("/getcars")
	public ResponseEntity<Object> getcars() {
		return ResponseEntity.ok(carRepository.findAll());
	}

	@GetMapping("/getbikes")
	public ResponseEntity<Object> getBikes() {
		return ResponseEntity.ok(bikeRepository.findAll());
	}
}
