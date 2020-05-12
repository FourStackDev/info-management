package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "work_experience")
public class WorkExperience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7827879667872296732L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "organization_name")
	@JsonProperty(value = "company_name")
	private String organizationName;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "start_date")
	@JsonProperty(value = "company_joined_date")
	private LocalDate startDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "end_date")
	@JsonProperty(value = "company_exit_date")
	private LocalDate endDate;
	
	@Column(name = "is_current_org")
	@JsonProperty(value = "is_current_org")
	private boolean isCurrentOrganization;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "professional_id")
	@JsonProperty(value = "projects")
	private List<ProjectDetail> projects = new ArrayList<>();
	
	/**
	 * No argument constructor. It is used by JPA for transactions
	 */
	public WorkExperience() {
	}

	/**
	 * Parameterised Constructor to initilaize the WorkExperience object
	 * 
	 * @param organizationName      Name of the Organization
	 * @param startDate             Joining date of the Organization
	 * @param endDate               Exit date of the Organization (will be null if
	 *                              isCurrentOrganization is true)
	 * @param isCurrentOrganization Still working in the same Organization
	 */
	public WorkExperience(String organizationName, LocalDate startDate, LocalDate endDate,
			boolean isCurrentOrganization) {
		this.organizationName = organizationName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isCurrentOrganization = isCurrentOrganization;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isCurrentOrganization() {
		return isCurrentOrganization;
	}

	public void setCurrentOrganization(boolean isCurrentOrganization) {
		this.isCurrentOrganization = isCurrentOrganization;
	}

	public List<ProjectDetail> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDetail> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "WorkExperience [organizationName=" + organizationName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", isCurrentOrganization=" + isCurrentOrganization + "]";
	}
}
