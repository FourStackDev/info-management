package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.Person;

public interface PersonService {
	
	public List<Person> getPersons();

	public Person savePerson(Person person);
}
