package org.fourstack.infomanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface <b><i>PersonRepository</i></b> is a child interface of
 * JpaRepository.<br/>
 * <p>
 * This repository additionally defines methods to provide support for the Info
 * management application
 * </p>
 * 
 * @author Manjunath_Hm
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * To retrieve List of {@link Person} Objects based on First name and Last name
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @return List of Person Objects
	 */
	public List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name and Last name
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @param pageable  Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on First name
	 * 
	 * @param firstName First Name
	 * @return Container having the List of Person Object
	 */
	public Optional<List<Person>> findByFirstName(String firstName);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name
	 * 
	 * @param firstName First Name
	 * @param pageable  Pageable Object
	 * @return Container having Page of Person Object
	 */
	public Optional<Page<Person>> findByFirstName(String firstName, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on Last name
	 * 
	 * @param lastName Last Name
	 * @return Container having List of Person Object
	 */
	public Optional<List<Person>> findByLastName(String lastName);

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name
	 * 
	 * @param lastName Last Name
	 * @param pageable Pageable Object
	 * @return Container having Page of Person Object
	 */
	public Optional<Page<Person>> findByLastName(String lastName, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on Gender
	 * 
	 * @param gender Gender Type
	 * @return Container having List of Person Objects
	 */
	public Optional<List<Person>> findByGender(GenderType gender);

	/**
	 * To retrieve Page of {@link Person} Objects based on Gender
	 * 
	 * @param gender   Gender Type
	 * @param pageable Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByGender(GenderType gender, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on Marital Status
	 * 
	 * @param maritalStatus MaritalStatus Type
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByMaritalStatus(MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on Marital Status
	 * 
	 * @param maritalStatus MaritalStatus Type
	 * @param pageable      Pageable Object
	 * @return Container having page of Objects
	 */
	public Optional<Page<Person>> findByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on First name and Marital
	 * Status.
	 * 
	 * @param firstName     First name
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name and Marital
	 * Status.
	 * 
	 * @param firstName     First name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having page of Objects
	 */
	public Optional<Page<Person>> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus,
			Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on First name and Gender.
	 * 
	 * @param firstName First name
	 * @param gender    Gender
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndGender(String firstName, GenderType gender);
	
	/**
	 * To retrieve Page of {@link Person} Objects based on First name and Gender.
	 * 
	 * @param firstName First name
	 * @param gender    Gender
	 * @param pageable  Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstnameAndGender(String firstName, GenderType gender, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Gender and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Conatiner having list of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name, Gender and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Last name and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name, Last name and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus, Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Last name and
	 * Gender
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @param gender    Gender
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name, Last name and
	 * Gender
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @param gender    Gender
	 * @param pageable  Pageabe Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender, Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on Gender and Marital Status
	 * 
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	public Optional<List<Person>> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on Gender and Marital Status
	 * 
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having Page of Person Objects
	 */
	public Optional<Page<Person>> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus,
			Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on Last name and Marital
	 * Status
	 * 
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	public Optional<List<Person>> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name and Marital
	 * Status
	 * 
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having Page of Person Objects
	 */
	public Optional<Page<Person>> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus,
			Pageable pageable);

	/**
	 * To retrieve List of {@link Person} Objects based on Last name and Gender
	 * 
	 * @param lastName Last name
	 * @param gender   Gender
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByLastnameAndGender(String lastName, GenderType gender);

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name and Gender
	 * 
	 * @param lastName Last name
	 * @param gender   Gender
	 * @param pageable Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByLastnameAndGender(String lastName, GenderType gender, Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on Last name, Gender and
	 * Marital Status
	 * 
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name, Gender and
	 * Marital Status
	 * 
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable);
	
	/**
	 * To retrieve List of {@link Person} Objects based on First name, Last name,
	 * Gender and Marital Status
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Container having list of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus);

	/**
	 * To retrieve Page of {@link Person} Objects based on First name, Last name,
	 * Gender and Marital Status
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param page          Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<List<Person>> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus, Pageable page);
}
