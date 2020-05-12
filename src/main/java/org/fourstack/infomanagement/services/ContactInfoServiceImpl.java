package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.exceptionhandling.UniqueConstraintViolationException;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.repositories.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		try {
			contactInfo = contactRepository.save(contactInfo);
		} catch (DataIntegrityViolationException e) {
			throw new UniqueConstraintViolationException(
					"Unique Constraint Violation Occurred. Please check primary Conatct number and mail-id. "
					+ "The unique Constraints defined in Contact entity are Primary Contact Number and Mail-Id",
					e.getMessage(), e);
		}
		return contactInfo;
	}

	@Override
	public List<ContactInfo> saveContacts(List<ContactInfo> contactList) {
		return contactRepository.saveAll(contactList);
	}

}
