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
	
	public Optional<List<Person>> findByGender(GenderType gender);
	
	public Page<Person> findByGender(GenderType gender, Pageable pageable);
	
	public Optional<List<Person>> findByMaritalStatus(MaritalStatus maritalStatus);
	
	public Page<Person> findByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable);
	
	
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
	public Optional<List<Person>> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus);

	public Page<Person> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> findByFirstnameAndGender(String firstName, GenderType gender);

	public Page<Person> findByFirstnameAndGender(String firstName, GenderType gender, Pageable pageable);

	public Optional<List<Person>> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus);

	public Page<Person> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus);

	public Page<Person> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender);

	public Page<Person> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender, Pageable pageable);

	public Optional<List<Person>> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus);

	public Page<Person> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus);

	public Page<Person> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus,
			Pageable pageable);

	public Optional<List<Person>> findByLastnameAndGender(String lastName, GenderType gender);

	public Page<Person> findByLastnameAndGender(String lastName, GenderType gender, Pageable pageable);

	public Optional<List<Person>> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus);

	public Page<Person> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);

	public Optional<List<Person>> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus);

	public Page<Person> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus, Pageable page);
	/*
	 * *****************************************************************************
	 * *****************************************************************************
	 */	
	
}
