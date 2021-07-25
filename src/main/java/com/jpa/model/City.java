package com.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_city"
	)
	@SequenceGenerator(
			name = "seq_city",
			allocationSize = 1,
			sequenceName = "city_sequence"
	)
	@JsonIgnore
	private Long cityId;

	@Column(
			name = "city_name",
			columnDefinition = "character varying(50) not null"
	)
	private String cityName;

	@Column(name = "country_id")
	private Long countryId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "country_id",
			referencedColumnName = "id",
			columnDefinition = "bigint not null default 0",
			insertable = false,
			updatable = false
	)
	private Country country;

}
