package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.exceptionhandling.RequestedEntityNotFoundException;
import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
		if (personList != null)
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

}
