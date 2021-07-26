package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
