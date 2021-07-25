package com.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(
		name = "countries",
		uniqueConstraints = @UniqueConstraint(
				name = "unique_country_name",
				columnNames = "country_name"
		)
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_country")
	@SequenceGenerator(
			name = "seq_country",
			allocationSize = 1,
			sequenceName = "country_sequence"
	)
	@Column(name = "id")
	@JsonIgnore
	private Long countryId;

	@Column(
			name = "country_name",
			columnDefinition = "character varying(50) not null",
			unique = true
	)
	private String countryName;

	@JsonIgnore
	@OneToMany
	@JoinColumn(
			name = "country_id",
			referencedColumnName = "id"
	)
	private Set<City> cities;
}
