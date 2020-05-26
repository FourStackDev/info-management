package org.fourstack.infomanagement.payload;

import java.io.Serializable;

import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.models.ProfessionalInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PayLoad used to handle both {@link Person} information and
 * {@link ProfessionalInfo} information. <br>
 * <p>
 * Using this PayLoad extract the Person information and Professional
 * Information separately, then persist them to Database. After persisting both
 * the Entities, map both Entities into a separate table.
 * </p>
 * 
 * @author Manjunath HM
 *
 */
public class PersonalProfessionalInfoPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4540758323540554924L;

	@JsonProperty(value = "personal_info")
	private Person person;

	@JsonProperty(value = "professional_info")
	private ProfessionalInfo professionalInfo;

	/**
	 * No Argument constructor for default initialization of Object
	 */
	public PersonalProfessionalInfoPayload() {
	}

	/**
	 * Parameterized Constructor to initialize the Object
	 * 
	 * @param person           {@link Person} Object
	 * @param professionalInfo {@link ProfessionalInfo} Object
	 */
	public PersonalProfessionalInfoPayload(Person person, ProfessionalInfo professionalInfo) {
		this.person = person;
		this.professionalInfo = professionalInfo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ProfessionalInfo getProfessionalInfo() {
		return professionalInfo;
	}

	public void setProfessionalInfo(ProfessionalInfo professionalInfo) {
		this.professionalInfo = professionalInfo;
	}
}
