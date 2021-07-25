package com.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_contents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseContent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_coursecontent")
	@SequenceGenerator(sequenceName = "coursecontent_sequence",allocationSize = 1,name = "seq_coursecontent")
	@Column(name = "id")
	private Long courseContentId;

	@Column(name = "course_content")
	private String content;

	@ManyToMany(mappedBy = "courseContents")
	@JsonIgnore
	private Set<Course> courses = new HashSet<>();

	public  void addCourse(Course course){
		this.courses.add(course);
	}
}
