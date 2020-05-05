package org.fourstack.infomanagement.models;

import java.io.Serializable;

public class ProfessionalInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8549999200531358171L;
	
	
	private Long Id;
	
	
	private int totalExperience; // stored as months
	private int relevantExperience; // stored as months
	private String currentOrganization;
	private String designation;

}
