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
		List<Person> personList = personRepository.findByFirstnameAndLastname(firstName, lastName);
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
		Optional<Page<Person>> optional = personRepository.findByFirstnameAndLastname(firstName, lastName, pageable);
		
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
		Optional<List<Person>> optional = personRepository.findByFirstname(firstName);
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
		Optional<Page<Person>> optionalPage = personRepository.findByFirstname(firstName, pageable);
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
		Optional<List<Person>> optionalList = personRepository.findByLastname(lastName);
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
		Optional<Page<Person>> optionalPage = personRepository.findByLastname(lastName, pageable);
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
	 * @return Page of Person Objects
	 */
	@Override
	public Page<Person> findByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByMaritalStatus(maritalStatus, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

	
	/**
	 * To retrieve Page of {@link Person} Objects by using Pageable Object
	 * 
	 * @param pageable Pageable Object
	 * @return Page of Person Objects
	 */
	@Override
	public Page<Person> getPersons(Pageable pageable) {
		Page<Person> page = personRepository.findAll(pageable);
		if (page != null && page.getContent() != null && !page.getContent().isEmpty())
			return page;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}
	
	/**
	 * To retrieve List of {@link Person} Objects based on First name and Marital
	 * Status.
	 * 
	 * @param firstName     First name
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByFirstnameAndMaritalStatus(firstName, maritalStatus);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on First name and Marital
	 * Status.
	 * 
	 * @param firstName     First name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having page of Objects
	 */
	@Override
	public Page<Person> findByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus,
			Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstnameAndMaritalStatus(firstName, maritalStatus, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}
	
	/**
	 * To retrieve List of {@link Person} Objects based on First name and Gender.
	 * 
	 * @param firstName First name
	 * @param gender    Gender
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByFirstnameAndGender(String firstName, GenderType gender) {
		Optional<List<Person>> optionalList = personRepository.findByFirstnameAndGender(firstName, gender);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}
	
	/**
	 * To retrieve Page of {@link Person} Objects based on First name and Gender.
	 * 
	 * @param firstName First name
	 * @param gender    Gender
	 * @param pageable  Pageable Object
	 * @return Container having page of Person Objects
	 */
	@Override
	public Page<Person> findByFirstnameAndGender(String firstName, GenderType gender, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstnameAndGender(firstName, gender, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Gender and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Conatiner having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByFirstnameAndGenderAndMaritalStatus(firstName,
				gender, maritalStatus);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;

		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

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
	@Override
	public Page<Person> findByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstnameAndGenderAndMaritalStatus(firstName, gender, maritalStatus, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Last name and
	 * Marital Status
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByFirstnameAndLastnameAndMaritalStatus(firstName, lastName, maritalStatus);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

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
	@Override
	public Page<Person> findByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstnameAndLastnameAndMaritalStatus(firstName, lastName, maritalStatus, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on First name, Last name and
	 * Gender
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @param gender    Gender
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender) {
		Optional<List<Person>> optionalList = personRepository.findByFirstnameAndLastnameAndGender(firstName, lastName, gender);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

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
	@Override
	public Page<Person> findByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByFirstnameAndLastnameAndGender(firstName, lastName, gender, pageable);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");		
	}
	
	/**
	 * To retrieve List of {@link Person} Objects based on Gender and Marital Status
	 * 
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByGenderAndMaritalStatus(gender, maritalStatus);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on Gender and Marital Status
	 * 
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having Page of Person Objects
	 */
	@Override
	public Page<Person> findByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus,
			Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByGenderAndMaritalStatus(gender, maritalStatus, pageable);
		Page<Person> personPage = optionalPage.orElse(null);
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}
	
	/**
	 * To retrieve List of {@link Person} Objects based on Last name and Marital
	 * Status
	 * 
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @return Container having List of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByLastnameAndMaritalStatus(lastName, maritalStatus);
		List<Person> personList = optionalList.orElse(null);
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name and Marital
	 * Status
	 * 
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return Container having Page of Person Objects
	 */
	@Override
	public Page<Person> findByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus,
			Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByLastnameAndMaritalStatus(lastName, maritalStatus,
				pageable);
		Page<Person> personPage = optionalPage.orElse(null);
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;

		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

	/**
	 * To retrieve List of {@link Person} Objects based on Last name and Gender
	 * 
	 * @param lastName Last name
	 * @param gender   Gender
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByLastnameAndGender(String lastName, GenderType gender) {
		Optional<List<Person>> optionalList = personRepository.findByLastnameAndGender(lastName, gender);
		List<Person> personList = optionalList.orElse(null);
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

	/**
	 * To retrieve Page of {@link Person} Objects based on Last name and Gender
	 * 
	 * @param lastName Last name
	 * @param gender   Gender
	 * @param pageable Pageable Object
	 * @return Container having page of Person Objects
	 */
	@Override
	public Page<Person> findByLastnameAndGender(String lastName, GenderType gender, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByLastnameAndGender(lastName, gender, pageable);
		Page<Person> personPage = optionalPage.orElse(null);
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}
	
	/**
	 * To retrieve List of {@link Person} Objects based on Last name, Gender and
	 * Marital Status
	 * 
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @return Container having list of Person Objects
	 */
	@Override
	public Optional<List<Person>> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository.findByLastnameAndGenderAndMaritalStatus(lastName, gender,
				maritalStatus);
		List<Person> personList = optionalList.orElse(null);
		if (personList != null && !personList.isEmpty())
			return optionalList;

		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

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
	@Override
	public Page<Person> findByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable) {
		Optional<Page<Person>> optionalPage = personRepository.findByLastnameAndGenderAndMaritalStatus(lastName, gender,
				maritalStatus, pageable);
		Page<Person> personPage = optionalPage.orElse(null);
		if (personPage != null && personPage.getContent() != null && personPage.getContent().isEmpty())
			return personPage;

		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}
	
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
	@Override
	public Optional<List<Person>> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus) {
		Optional<List<Person>> optionalList = personRepository
				.findByFirstnameAndLastnameAndGenderAndMaritalStatus(firstName, lastName, gender, maritalStatus);
		List<Person> personList = optionalList.isPresent() ? optionalList.get() : null;
		if (personList != null && !personList.isEmpty())
			return optionalList;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty List");
	}

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
	@Override
	public Page<Person> findByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus, Pageable page) {
		Optional<Page<Person>> optionalPage = personRepository
				.findByFirstnameAndLastnameAndGenderAndMaritalStatus(firstName, lastName, gender, maritalStatus, page);
		Page<Person> personPage = optionalPage.isPresent() ? optionalPage.get() : null;
		if (personPage != null && personPage.getContent() != null && !personPage.getContent().isEmpty())
			return personPage;
		
		throw new RequestedEntityNotFoundException("Requested Entites are not Found: Returned empty Page");
	}

}
