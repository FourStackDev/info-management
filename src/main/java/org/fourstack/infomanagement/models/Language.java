package org.fourstack.infomanagement.models;

import java.io.Serializable;

import org.fourstack.infomanagement.codetype.Proficiency;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3489393199207962487L;
	
	@JsonProperty(value = "language_name")
	private String name;
	private Proficiency proficiency;

}
