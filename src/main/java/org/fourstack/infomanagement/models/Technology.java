package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>Technology</i></b> is an Entity class used to store the
 * Technologies used by the Project.<br/>
 * It is a sub entity for {@link ProjectDetail} Entity
 * <p>
 * In this class both 'technology_name' and 'version' combinedly acts as unique
 * constraint
 * </p>
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "technologies", uniqueConstraints = {
		@UniqueConstraint(name = "uniqueTechnologyConstraint", columnNames = { "technology_name", "version" }) })
public class Technology implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157408858732324079L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "technology_name")
	@JsonProperty(value = "technology_name")
	private String name;

	@Column(name = "version")
	@JsonProperty(value = "technology_version")
	private String version;
	
	/**
	 * Here we mentioned that the joining will be taken care by the technologies
	 * variable in ProjectDetail
	 */
	@ManyToMany(mappedBy = "technologies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProjectDetail> projects = new ArrayList<>();

	/**
	 * No argument Constructor
	 */
	public Technology() {
	}

	/**
	 * Parameterized Constructor to initialize the Technology Object
	 * 
	 * @param name    Name of the Technology
	 * @param version Version of the technology
	 */
	public Technology(String name, String version) {
		super();
		this.name = name;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<ProjectDetail> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDetail> projects) {
		this.projects = projects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = prime * hashValue + this.getClass().getName().hashCode();
		
		//compute hashValue for name and version, then add them to initial hashValue
		hashValue = prime * hashValue + ((name != null) ? name.hashCode() : 0);
		hashValue = prime * hashValue + ((version != null) ? version.hashCode() : 0);
		
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Technology other = (Technology) obj;
		/*
		 * if name is null, check with other.getName() and other.getName() is not null
		 * return false. if name is not null, then compare both values using equals()
		 * method
		 */
		if ((this.getName() == null) ? other.getName() != null : this.getName().equals(other.getName()))
			return false;

		if (this.getVersion() == null ? other.getVersion() != null : this.getVersion().equals(other.getName()))
			return false;

		/*
		 * if (this.getName() == null) { if (other.name != null) return false; } else if
		 * (!this.getName().equals(other.name)) return false;
		 */
		return true;
	}

	@Override
	public String toString() {
		return "Technology [name=" + name + ", version=" + version + "]";
	}
}
