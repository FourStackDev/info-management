package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.repositories.AddressRepository;
import org.fourstack.infomanagement.repositories.ContactInfoRepository;
import org.fourstack.infomanagement.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactInfoRepository contactInfoRepository;

	@Override
	public List<Person> getPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		
		ContactInfo contact = contactInfoRepository.save(person.getContactInfo());
		Address address = addressRepository.save(person.getAddress());
		
		person.setContactInfo(contact);
		person.setAddress(address);
		return personRepository.save(person);
	}

}
