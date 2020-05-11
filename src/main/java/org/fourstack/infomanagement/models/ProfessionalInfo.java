package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "professional_info")
public class ProfessionalInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8549999200531358171L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty(value = "total_years_of_exp")
	@Column(name = "total_exp")
	private int totalExperience; // stored as months

	@JsonProperty(value = "relevant_exp")
	@Column(name = "relevant_exp")
	private int relevantExperience; // stored as months

	@JsonProperty(value = "current_org")
	@Column(name = "current_organization")
	private String currentOrganization;

	@JsonProperty(value = "designation")
	@Column(name = "designation")
	private String designation;
	
	/*
	 * ****************************************************************************
	 * ************* Start of Mapping columns with other Entities *****************
	 * ****************************************************************************
	 */
	@OneToMany
	@JoinColumn(name = "professional_id")
	@JsonProperty(value = "education_details")
	private List<EducationDetail> educationalDetails;

	/*
	 * ****************************************************************************
	 * ************* End of Mapping columns with other Entities *******************
	 * ****************************************************************************
	 */

	/**
	 * createDateTime and updateDateTime columns are used to track the insertion and
	 * updation of Entities at database level
	 */
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false, updatable = true)
	private LocalDateTime updateDateTime;

	/**
	 * No arg constructor. It is needed for the JPA transactions
	 */
	public ProfessionalInfo() {
	}

	/**
	 * @param totalExperience
	 * @param relevantExperience
	 * @param currentOrganization
	 * @param designation
	 */
	public ProfessionalInfo(int totalExperience, int relevantExperience, String currentOrganization,
			String designation) {
		this.totalExperience = totalExperience;
		this.relevantExperience = relevantExperience;
		this.currentOrganization = currentOrganization;
		this.designation = designation;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getRelevantExperience() {
		return relevantExperience;
	}

	public void setRelevantExperience(int relevantExperience) {
		this.relevantExperience = relevantExperience;
	}

	public String getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(String currentOrganization) {
		this.currentOrganization = currentOrganization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<EducationDetail> getEducationalDetails() {
		return educationalDetails;
	}

	public void setEducationalDetails(List<EducationDetail> educationalDetails) {
		this.educationalDetails = educationalDetails;
	}
}
