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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "project_details")
public class ProjectDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2434236462836489298L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "project_name")
	@JsonProperty(value = "project_name")
	private String projectName;
	
	@Column(name = "team_size")
	@JsonProperty(value = "team_size")
	private int teamSize;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "start_date")
	@JsonProperty(value = "start_date")
	private LocalDate startDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "end_date")
	@JsonProperty(value = "end_date")
	private LocalDate endDate;
	
	@Column(name = "project_description", columnDefinition = "TEXT")
	@JsonProperty(value = "project_description")
	private String description;

	/**
	 * technologies and project details are mapped by using the ManyToMany with a
	 * Join table. Here Project is the owner of the table and technologies will
	 * refer to the same table only
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
			CascadeType.REMOVE
	})
	@JoinTable(name = "projects_technologies", joinColumns = @JoinColumn(name = "project_id"),
	inverseJoinColumns = @JoinColumn(name = "technology_id"))
	@JsonProperty(value = "technologies_used")
	private List<Technology> technologies = new ArrayList<>();
	
	/**
	 * No argument Constructor. It is used for the JPA Transactions
	 */
	public ProjectDetail() {}

	/**
	 * @param projectName Name of the Project
	 * @param teamSize    Size of team
	 * @param startDate   Strat date of the project
	 * @param endDate     End date of the Project
	 * @param description Summary about the Project
	 */
	public ProjectDetail(String projectName, int teamSize, LocalDate startDate, LocalDate endDate, String description) {
		this.projectName = projectName;
		this.teamSize = teamSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "ProjectDetail [projectName=" + projectName + ", teamSize=" + teamSize + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + ", technologies=" + technologies + "]";
	}
}
