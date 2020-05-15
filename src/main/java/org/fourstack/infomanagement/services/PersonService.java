package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

	public List<Person> getPersons();
	
	public Page<Person> getPersons(Pageable pageable);

	public Person savePerson(Person person);

	public List<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName);

	public Page<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName,
			Pageable pageable);
	
	public Optional<List<Person>> getPersonByFirstName(String firstName);

	public Page<Person> getPersonByFirstName(String firstName, Pageable pageable);

	public Optional<List<Person>> getPersonByLastName(String lastName);

	public Page<Person> getPersonByLastName(String lastName, Pageable pageable);
	
	public Optional<List<Person>> getPersonListByGender(GenderType gender);
	
	public Page<Person> getPersonListByGender(GenderType gender, Pageable pageable);
	
	public Optional<List<Person>> getPersonListByMaritalStatus(MaritalStatus maritalStatus);
	
	public Page<Person> getPersonListByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable);
	
	
	/*
	 * *****************************************************************************
	 * ** Methods to handle the Multiple combinations to fetch the Person Objects **
	 * *****************************************************************************
	 * ******************** Conditions are metioned below **************************
	 * <ul> 
	 * <li> Person list by firstName and marital Status </li> 
	 * <li> Person list by firstName and gender </li> 
	 * <li> Person list by firstName, gender and marital status </li> 
	 * <li> Person list by firstName, lastname and marital status </li> 
	 * <li> Person list by firstName, lastname and gender </li>
	 * <li> Person list by gender and marital status </li>
	 * <li> Person list by lastname and marital status </li>
	 * <li> Person list by lastname and gender </li>
	 * <li> Person list by lastname, gender and marital status </li>
	 * <li> Person list by firstName, lastname, gender and marital status </li>
	 * </ul>
	 * 
	 * *****************************************************************************
	 */
	public Optional<List<Person>> getPersonListByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus);

	public Page<Person> getPersonListByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> getPersonListByFirstnameAndGender(String firstName, GenderType gender);

	public Page<Person> getPersonListByFirstnameAndGender(String firstName, GenderType gender, Pageable pageable);

	public Optional<List<Person>> getPersonListByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus);

	public Page<Person> getPersonListByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> getPersonListByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus);

	public Page<Person> getPersonListByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> getPersonListByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender);

	public Page<Person> getPersonListByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender, Pageable pageable);

	public Optional<List<Person>> getPersonListByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus);

	public Page<Person> getPersonListByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> getPersonListByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus);

	public Page<Person> getPersonListByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> getPersonListByLastnameAndGender(String lastName, GenderType gender);

	public Page<Person> getPersonListByLastnameAndGender(String lastName, GenderType gender, Pageable pageable);

	public Optional<List<Person>> getPersonListByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus);

	public Page<Person> getPersonListByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> getPersonListByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus);

	public Page<Person> getPersonListByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus, Pageable page);
	/*
	 * *****************************************************************************
	 * *****************************************************************************
	 */	
	
}
