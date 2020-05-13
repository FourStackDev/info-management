package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.exceptionhandling.RequestedEntityNotFoundException;
import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@Autowired
	private LanguageService languageService;
	
	@Override
	public List<Person> getPersons() {
		List<Person> personList = personRepository.findAll();
		if (personList != null && !personList.isEmpty())
			return personList;
		else
			throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty List");
	}

	@Override
	public Person savePerson(Person person) {
		ContactInfo contact = null;
		Address address = null;

		if (person.getContactInfo() != null) {
			contact = contactInfoService.saveContact(person.getContactInfo());
			person.setContactInfo(contact);
		}

		if (person.getAddress() != null) {
			address = addressService.saveAddress(person.getAddress());
			person.setAddress(address);
		}

		if (person.getLanguages() != null) {
			List<Language> languages = person.getLanguages();
			languages = languageService.saveAllLanguages(languages);

			person.getLanguages().clear();
			person.getLanguages().addAll(languages);
		}

		return person = personRepository.save(person);
	}

	/**
	 * Retrieve the List of Person Objects Based on the First name and Last name
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @return List of Person Objects
	 */
	@Override
	public List<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName) {
		List<Person> personList = personRepository.findByFirstNameAndLastName(firstName, lastName);
		if (personList != null && !personList.isEmpty())
			return personList;
		else
			throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty List");
	}

	/**
	 * Retrieve the Page of Person Objects Based on the First name and Last name
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @param pageable  Pageable Object
	 * @return Page of Person Objects
	 */
	@Override
	public Optional<Page<Person>> getPersonsByFirstnameAndLastName(String firstName, String lastName,
			Pageable pageable) {
		return null;
	}

	/**
	 * Retrieve the List of Person Objects Based on the First name
	 * 
	 * @param firstName First Name
	 * @return Container with List of Persons
	 */
	@Override
	public Optional<List<Person>> getPersonByFirstName(String firstName) {
		return null;
	}

	/**
	 * Retrieve the Page of Person Object Based on the First name
	 * 
	 * @param firstName First name
	 * @param pageable  Pageable Object
	 * @return Container with Page of Persons
	 */
	@Override
	public Optional<Page<Person>> getPersonByFirstName(String firstName, Pageable pageable) {
		return null;
	}

	/**
	 * Retrieve the List of Person Object Based on the Last name
	 * 
	 * @param LastName Last Name
	 * @return Container with List of Person Objects
	 */
	@Override
	public Optional<List<Person>> getPersonByLastName(String LastName) {
		return null;
	}

	/**
	 * Retrieve the Page of Person Object Based on the First name
	 * 
	 * @param LastName Last Name
	 * @param pageable Pageable Object
	 * @return Container with Page of Person Objects
	 */
	@Override
	public Optional<Page<Person>> getPersonByLastName(String LastName, Pageable pageable) {
		return null;
	}

}
