package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkExperience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7827879667872296732L;
	
	private Long Id;
	
	@JsonProperty(value = "company_name")
	private String organizationName;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean isCurrentOrganization;

}
