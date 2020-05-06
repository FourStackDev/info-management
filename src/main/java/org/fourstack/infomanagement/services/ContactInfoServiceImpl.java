package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.repositories.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService{
	
	@Autowired
	private ContactInfoRepository contactRepository;

	@Override
	public List<ContactInfo> getContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<ContactInfo> getContact(long id) {
		return contactRepository.findById(id);
	}

	@Override
	public ContactInfo saveContact(ContactInfo contactInfo) {
		return contactRepository.save(contactInfo);
	}

	@Override
	public List<ContactInfo> saveContacts(List<ContactInfo> contactList) {
		return contactRepository.saveAll(contactList);
	}

}
