package com.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.City;
import com.jpa.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public List<City> addCity(List<City> cities) {
		return cities.stream().map(city -> cityRepository.save(city)).collect(Collectors.toList());
	}

	public List<City> getCities() {
		return cityRepository.findAll();
	}

}
