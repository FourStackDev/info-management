package org.fourstack.infomanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.fourstack.infomanagement.codetype.CourseType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "education_details")
public class EducationDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371635814240337224L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty(value = "university_name")
	@Column(name = "university")
	private String universityName;
	
	@JsonProperty(value = "college_name")
	@Column(name = "collge")
	private String collgeName;

	@JsonProperty(value = "course_name")
	@Column(name = "course")
	private String courseName;

	@JsonProperty(value = "year_of_passed_out")
	@Column(name = "pass_out_year")
	private String passOutYear;

	@JsonProperty(value = "course_type")
	@Enumerated(EnumType.STRING)
	@Column(name = "course_type")
	private CourseType courseType;

	/**
	 * No argument Constructor. It is needed for the JPA transactions
	 */
	public EducationDetail() {
	}
	
	/**
	 * Parameterized constructor to initialize the EducationDetail Entity
	 * 
	 * @param universityName Name of the University
	 * @param collgeName     Name of the College
	 * @param courseName     Name of Course/Degree
	 * @param passOutYear    Year of passed out
	 * @param courseType     Type of Course (Full time/ part time / Correspondence)
	 */
	public EducationDetail(String universityName, String collgeName, String courseName, String passOutYear,
			CourseType courseType) {
		this.universityName = universityName;
		this.collgeName = collgeName;
		this.courseName = courseName;
		this.passOutYear = passOutYear;
		this.courseType = courseType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(String passOutYear) {
		this.passOutYear = passOutYear;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public String getCollgeName() {
		return collgeName;
	}

	public void setCollgeName(String collgeName) {
		this.collgeName = collgeName;
	}

	@Override
	public String toString() {
		return "EducationDetail [universityName=" + universityName + ", collgeName=" + collgeName + ", courseName="
				+ courseName + ", passOutYear=" + passOutYear + ", courseType=" + courseType + "]";
	}
}
