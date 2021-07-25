package com.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		name = "courses"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_course")
	@SequenceGenerator(name = "seq_course",allocationSize = 1,sequenceName = "course_sequence")
	@Column(name = "id")
	private Long courseId;

	@Column(
			name = "course_name",
			columnDefinition = "character varying(50) not null",
			unique = true
	)
	private String courseName;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(
			name = "course_coursecontent_mapping",
			joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "coursecontent_id",referencedColumnName = "id")
	)
	private Set<CourseContent> courseContents = new HashSet<>();
}
