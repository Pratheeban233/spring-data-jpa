package com.jpa.repository;

import com.jpa.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void addCountry(){
		Country country =
				Country.builder().countryName("US").build();
		System.out.println("countryRepository.save(country) = " + countryRepository.save(country));
	}

}