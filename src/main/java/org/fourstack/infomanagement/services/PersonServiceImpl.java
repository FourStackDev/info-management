package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
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
	
	@Override
	public List<Person> getPersons() {
		return personRepository.findAll();
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
		
		return personRepository.save(person);
	}

}
