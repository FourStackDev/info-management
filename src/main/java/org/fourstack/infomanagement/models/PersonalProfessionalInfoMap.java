package org.fourstack.infomanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_profession_mappings")
public class PersonalProfessionalInfoMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964212431106999130L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_profession_mappings_id")
	private Long id;

	@Column(name = "person_id")
	private Long personId;

	@Column(name = "profession_id")
	private Long professionalId;

	public PersonalProfessionalInfoMap() {
	}

	/**
	 * Parameterized Constructor to initialize the Object.
	 * 
	 * @param personId       {@link Person} Entity Id
	 * @param professionalId {@link ProfessionalInfo} Entity Id
	 */
	public PersonalProfessionalInfoMap(Long personId, Long professionalId) {
		this.personId = personId;
		this.professionalId = professionalId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
}
