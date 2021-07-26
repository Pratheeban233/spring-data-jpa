package com.jpa.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "commonDate", column = @Column(name = "visit_date"))
public class Patient extends PersonalInfo implements Serializable {

	@Column(name = "symptoms", columnDefinition = "character varying(55) not null")
	private String symptoms;

	@Column(name = "health_history", columnDefinition = "character varying(50)")
	private String healthHistory;

}
