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

	public Person savePerson(Person person);

	public List<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName);

	public Page<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName,
			Pageable pageable);
	
	public Optional<List<Person>> getPersonByFirstName(String firstName);

	public Optional<Page<Person>> getPersonByFirstName(String firstName, Pageable pageable);

	public Optional<List<Person>> getPersonByLastName(String LastName);

	public Optional<Page<Person>> getPersonByLastName(String LastName, Pageable pageable);
	
	public Optional<List<Person>> findByGender(GenderType gender);
	
	public Optional<Page<Person>> findByGender(GenderType gender, Pageable pageable);
	
	public Optional<List<Person>> findByMaritalStatus(MaritalStatus maritalStatus);
	
	public Optional<Page<Person>> findByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable);
}
