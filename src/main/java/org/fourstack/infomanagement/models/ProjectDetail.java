package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2434236462836489298L;
	
	private Long id;
	private String projectName;
	private int teamSize;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@JsonProperty(value = "project_description")
	private String description;
	
	@JsonProperty(value = "technologies_used")
	private List<Technology> technologies;
	
	
	

}
