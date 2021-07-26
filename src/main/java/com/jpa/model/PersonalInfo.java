package com.jpa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@MappedSuperclass
@Data
public class PersonalInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "character varying (50) not null")
	private String name;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "address", columnDefinition = "character varying(50)")
	private String address;

	@Column(name = "mobile", columnDefinition = "character varying(10) ")
	private String mobile;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime commonDate;
}
