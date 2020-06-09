package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.repositories.ContactInfoRepository;
import org.fourstack.infomanagement.services.ContactInfoServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ContactInfoServiceTest {
	
	@Mock
	private ContactInfoRepository contactRepository;
	
	@InjectMocks
	private ContactInfoServiceImpl contactService;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_getContacts() {
		List<ContactInfo> contacts = EntityGenerator.getContactInfoList();
		
		// mock the repository call
		when(contactRepository.findAll()).thenReturn(contacts);
		
		// call the service method
		List<ContactInfo> contactsList = contactService.getContacts();
		
		// verify the results
		assertEquals(contacts.size(), contactsList.size());
	}
	
	@Test
	public void test_getContactById() {
		Long id = CommonUtils.getRandomLong();
		ContactInfo contactInfo = EntityGenerator.getContactInfoForId(id);
		
		// mock the repository
		when(contactRepository.findById(id)).thenReturn(Optional.of(contactInfo));
		
		// call the service method
		Optional<ContactInfo> contact = contactService.getContact(id);
		
		//verify the results
		assertEquals(contactInfo.getId(), contact.get().getId());
		assertEquals(contactInfo.getPrimaryContactNum(), contact.get().getPrimaryContactNum());
		assertEquals(contactInfo.getSecondaryContactNum(), contact.get().getSecondaryContactNum());
		assertEquals(contactInfo.getMailId(), contact.get().getMailId());
	}
	
	@Test
	public void test_saveContact() {
		ContactInfo contactInfo = EntityGenerator.getContactInfoForId(CommonUtils.getRandomLong());
		
		// mock the repository
		when(contactRepository.save(contactInfo)).thenReturn(contactInfo);
		
		// call the service
		ContactInfo savedContact = contactService.saveContact(contactInfo);
		
		// verify the results
		assertEquals(contactInfo.getId(), savedContact.getId());
		assertEquals(contactInfo.getPrimaryContactNum(), savedContact.getPrimaryContactNum());
		assertEquals(contactInfo.getSecondaryContactNum(), savedContact.getSecondaryContactNum());
		assertEquals(contactInfo.getMailId(), savedContact.getMailId());
	}
}
