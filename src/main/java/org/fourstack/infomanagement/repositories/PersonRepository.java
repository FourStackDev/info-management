package org.fourstack.infomanagement.repositories;

import java.util.List;
import java.util.Optional;

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
	 * To retrieve List of Person Objects based on First name and Last name
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @return List of Person Objects
	 */
	public List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	/**
	 * To retrieve Page of Person Objects based on First name and Last name
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @param pageable  Pageable Object
	 * @return Container having page of Person Objects
	 */
	public Optional<Page<Person>> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

	/**
	 * To retrieve List of Person Objects based on First name
	 * 
	 * @param firstName First Name
	 * @return Container having the List of Person Object
	 */
	public Optional<List<Person>> findByFirstName(String firstName);

	/**
	 * To retrieve Page of Person Objects based on First name
	 * 
	 * @param firstName First Name
	 * @param pageable  Pageable Object
	 * @return Container having Page of Person Object
	 */
	public Optional<Page<Person>> findByFirstName(String firstName, Pageable pageable);

	/**
	 * To retrieve List of Person Objects based on Last name
	 * 
	 * @param lastName Last Name
	 * @return Container having List of Person Object
	 */
	public Optional<List<Person>> findByLastName(String lastName);

	/**
	 * To retrieve Page of Person Objects based on Last name
	 * 
	 * @param lastName Last Name
	 * @param pageable Pageable Object
	 * @return Container having Page of Person Object
	 */
	public Optional<Page<Person>> findByLastName(String lastName, Pageable pageable);

}
