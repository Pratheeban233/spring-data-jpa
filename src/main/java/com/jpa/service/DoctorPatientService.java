package com.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.Doctor;
import com.jpa.model.Patient;
import com.jpa.repository.DoctorRepository;
import com.jpa.repository.PatientRepository;

@Service
public class DoctorPatientService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
}
