package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>ProfessionalInfo</i></b> is an Entity Class to maintain the
 * Professional Information related to {@link Person}.
 * <p>
 * The sub entities of ProfessionalInfo are :
 * <ul>
 * <li>{@link ProfessionalSkill}</li>
 * <li>{@link WorkExperience}</li>
 * <li>{@link EducationDetail}</li>
 * </ul>
 * </p>
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "professional_info")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
	/**
	 * educationalDetails is mapped by using @OneToMany with Unidirectional.
	 * Education_details table will maintain the professional_id for mapping.
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.REMOVE,
			CascadeType.DETACH
	}, orphanRemoval = true)
	@JoinColumn(name = "professional_id")
	@JsonProperty(value = "education_details")
	private List<EducationDetail> educationalDetails = new ArrayList<>();
	
	/**
	 * professionalSkills is mapped by using @OneToMany with Unidirectional.
	 * Professional_skills table will maintain the professional_id for mapping.
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "professional_id")
	@JsonProperty(value = "professional_skills")
	private List<ProfessionalSkill> professionalSkills = new ArrayList<>();

	/**
	 * workExperiences is mapped by using @OneToMany with Unidirectional.
	 * Work_Experience table will maintain the professional_id for mapping.
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "professional_id")
	@JsonProperty(value = "work_experiences")
	private List<WorkExperience> workExperiences = new ArrayList<>();

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
	 * @param totalExperience     Total Experience in months
	 * @param relevantExperience  Relevant Experience in months
	 * @param currentOrganization Name of Current Organization
	 * @param designation         Current Designation
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

	public List<ProfessionalSkill> getProfessionalSkills() {
		return professionalSkills;
	}

	public void setProfessionalSkills(List<ProfessionalSkill> professionalSkills) {
		this.professionalSkills = professionalSkills;
	}

	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	@Override
	public String toString() {
		return "ProfessionalInfo [totalExperience=" + totalExperience + ", relevantExperience=" + relevantExperience
				+ ", currentOrganization=" + currentOrganization + ", designation=" + designation
				+ ", educationalDetails=" + educationalDetails + ", professionalSkills=" + professionalSkills
				+ ", workExperiences=" + workExperiences + "]";
	}
}
