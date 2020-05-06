package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ContactInfo;

public interface ContactInfoService {
	
	public List<ContactInfo> getContacts();
	
	public Optional<ContactInfo> getContact(long id);
	
	public ContactInfo saveContact(ContactInfo contactInfo);
	
	public List<ContactInfo> saveContacts(List<ContactInfo> contactList);
}
