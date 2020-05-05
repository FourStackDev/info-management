package org.fourstack.infomanagement.models;

import java.io.Serializable;

import org.fourstack.infomanagement.codetype.Proficiency;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfessionalSkill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -219293774031432557L;
	
	private Long id;
	
	@JsonProperty(value = "skill_name")
	private String name;
	
	private Proficiency proficiency;

}
