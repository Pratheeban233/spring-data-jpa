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
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "commonDate", column = @Column(name = "available_date"))
public class Doctor extends PersonalInfo implements Serializable {

	@Column(name = "room_no", columnDefinition = "int8 not null")
	private Long roomNo;
}
