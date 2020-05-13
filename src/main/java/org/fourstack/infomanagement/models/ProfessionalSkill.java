package org.fourstack.infomanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.fourstack.infomanagement.codetype.Proficiency;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity Class to maintain the Professional skills of a Person.<br/>
 * It is a sub entity of ProfessionalInfo.
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "professional_skills")
public class ProfessionalSkill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -219293774031432557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "skill_name", nullable = false)
	@JsonProperty(value = "skill_name")
	private String name;

	@Column(name = "proficiency")
	@JsonProperty(value = "proficiency")
	@Enumerated(EnumType.STRING)
	private Proficiency proficiency;

	/**
	 * No arg Constructor. It is needed for the JPA transactions
	 */
	public ProfessionalSkill() {
	}

	/**
	 * Parameterized Constructor to initialize the ProfessionalSkill Entity.
	 * 
	 * @param name        Name of skill
	 * @param proficiency Proficiency of Skill
	 */
	public ProfessionalSkill(String name, Proficiency proficiency) {
		this.name = name;
		this.proficiency = proficiency;
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

	public Proficiency getProficiency() {
		return proficiency;
	}

	public void setProficiency(Proficiency proficiency) {
		this.proficiency = proficiency;
	}

	@Override
	public String toString() {
		return "ProfessionalSkill [name=" + name + ", proficiency=" + proficiency + "]";
	}
}
