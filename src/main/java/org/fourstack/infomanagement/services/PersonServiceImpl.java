package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
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
	 * Retrieve the Page of {@link Person} Objects Based on the First name and Last name.
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @param pageable  Pageable Object
	 * @throws RequestedEntityNotFoundException If no entity found in the database
	 *                                          with provided first name and last
	 *                                          name.
	 * @return Page of Person Objects
	 */
	@Override
	public Page<Person> getPersonsByFirstnameAndLastName(String firstName, String lastName,
			Pageable pageable) {
		Optional<Page<Person>> optional = personRepository.findByFirstNameAndLastName(firstName, lastName, pageable);
		
		Page<Person> personPage = optional.isPresent() ? optional.get() : null;
		
		/*
		 * Check for the page, then content inside the page (it may be empty list some
		 * times) then check for empty list
		 */
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		else
			throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty Page");
	}

	/**
	 * Retrieve the List of {@link Person} Objects Based on the First name
	 * 
	 * @param firstName First Name
	 * @return Container with List of Persons
	 */
	@Override
	public Optional<List<Person>> getPersonByFirstName(String firstName) {
		Optional<List<Person>> optional = personRepository.findByFirstName(firstName);
		List<Person> personList = optional.isPresent() ? optional.get() : null;
		if (personList != null && !personList.isEmpty())
			return optional;

		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty List");
	}

	/**
	 * Retrieve the Page of {@link Person} Object Based on the First name
	 * 
	 * @param firstName First name
	 * @param pageable  Pageable Object
	 * @return Container with Page of Persons
	 */
	@Override
	public Page<Person> getPersonByFirstName(String firstName, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstName(firstName, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		/*
		 * Check for the page, then content inside the page (it may be empty list some
		 * times) then check for empty list
		 */
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty Page");
	}

	/**
	 * Retrieve the List of {@link Person} Object Based on the Last name
	 * 
	 * @param LastName Last Name
	 * @return Container with List of Person Objects
	 */
	@Override
	public Optional<List<Person>> getPersonByLastName(String lastName) {
		Optional<List<Person>> optionalList = personRepository.findByLastName(lastName);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * Retrieve the Page of {@link Person} Object Based on the First name
	 * 
	 * @param LastName Last Name
	 * @param pageable Pageable Object
	 * @return Container with Page of Person Objects
	 */
	@Override
	public Page<Person> getPersonByLastName(String lastName, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByLastName(lastName, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		/*
		 * Check for the page, then content inside the page (it may be empty list some
		 * times) then check for empty list
		 */
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned Empty Page");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on Gender
	 * 
	 * @param gender Gender Type
	 * @return Container having List of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByGender(GenderType gender) {
		Optional<List<Person>> optionalList = personRepository.findByGender(gender);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on Gender
	 * 
	 * @param gender   Gender Type
	 * @param pageable Pageable Object
	 * @return Container having page of Person Objects
	 */
	@Override
	public Page<Person> findByGender(GenderType gender, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByGender(gender, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		if (personPage != null && personPage.getContent() != null && !personPage.isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on Marital Status
	 * 
	 * @param maritalStatus MaritalStatus Type
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByMaritalStatus(MaritalStatus maritalStatus) {
		Optional<List<Person>> optional = personRepository.findByMaritalStatus(maritalStatus);
		List<Person> personlList = optional.isPresent() ? optional.get() : null;
		
		if (personlList != null && !personlList.isEmpty()) 
			return optional;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on Marital Status
	 * 
	 * @param maritalStatus MaritalStatus Type
	 * @param pageable      Pageable Object
	 * @return Container having page of Objects
	 */
	@Override
	public Page<Person> findByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByMaritalStatus(maritalStatus, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

}
