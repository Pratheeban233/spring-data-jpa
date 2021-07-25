package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
