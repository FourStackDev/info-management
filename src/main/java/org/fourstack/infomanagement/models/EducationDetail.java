package org.fourstack.infomanagement.models;

import java.io.Serializable;

import org.fourstack.infomanagement.codetype.CourseType;

public class EducationDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371635814240337224L;
	
	private String universityName;
	private String courseName;
	private String passOutYear;
	private CourseType courseType;

}
