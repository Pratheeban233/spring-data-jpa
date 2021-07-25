package com.jpa.repository;

import com.jpa.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.model.City;

@SpringBootTest
class CityRepositoryTest {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	CountryRepository countryRepository;

	@Test
	public void addCity() {

		Country country = countryRepository.getById(1L);

		City city = City.builder()
				.cityName("chennai")
				.country(country)
				.build();
		System.out.println("cityRepository.save(city) = " + cityRepository.save(city));
	}

	@Test
	public void getCities() {
		System.out.println("cityRepository.findAll() = " + cityRepository.findAll());
	}

	@Test
	public void deleteCity() {
		cityRepository.deleteById(6L);
		System.out.println("CityRepositoryTest.deleteCity : Deleted Successfully.");
	}

}