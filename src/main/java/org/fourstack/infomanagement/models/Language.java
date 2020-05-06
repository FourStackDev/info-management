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
 * Class <b><i>Language</i></b> is an Entity class, which is designed to handle
 * the languages known to the person Object. <br/>
 * 
 * It is sub entity for the Person entity
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "language")
public class Language implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3489393199207962487L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "language_name")
	@JsonProperty(value = "language_name")
	private String name;
	
	@Column(name = "proficiency")
	@Enumerated(EnumType.STRING)
	@JsonProperty(value  = "proficiency")
	private Proficiency proficiency;
	
	/**
	 * No argument Constructor
	 */
	public Language() {
	}

	/**
	 * Parameterized constructor to initialize the Language Object
	 * 
	 * @param name
	 * @param proficiency
	 */
	public Language(String name, Proficiency proficiency) {
		super();
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
		return "Language [name=" + name + ", proficiency=" + proficiency + "]";
	}
}
