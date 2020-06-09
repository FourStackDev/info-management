package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.repositories.AddressRepository;
import org.fourstack.infomanagement.services.AddressServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit Test class to support the test cases for AddressService. Class contains
 * the test cases related to the class AddressService. As this is a unit test
 * case class, we will mock the Repository layer and test only the code for
 * Service layer.
 * 
 * @author Manjunath_Hm
 *
 */
public class AddressServiceTest {

	@Mock
	private AddressRepository addressRepository;

	@InjectMocks
	private AddressServiceImpl addressService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getAllAddresses() {
		// mock the repository call
		when(addressRepository.findAll()).thenReturn(EntityGenerator.getAddressList());

		// call the service layer
		List<Address> addressList = addressService.getAllAddresses();

		// verify the result
		assertEquals(EntityGenerator.getAddressList().size(), addressList.size());
	}

	@Test
	public void test_getAddressById() {
		Long id = CommonUtils.getRandomLong();
		// mock the repository call
		when(addressRepository.findById(id)).thenReturn(Optional.of(EntityGenerator.getAddressForId(id)));

		// call the service method
		Optional<Address> address = addressService.getAddressById(id);

		// verify the result
		assertEquals(EntityGenerator.getAddressForId(id).getId(), address.get().getId());
		assertEquals(EntityGenerator.getAddressForId(id).getCountry(), address.get().getCountry());
		assertEquals(EntityGenerator.getAddressForId(id).getPincode(), address.get().getPincode());
		assertEquals(EntityGenerator.getAddressForId(id).getState(), address.get().getState());
	}
	
	@Test
	public void test_saveAddress() {
		Address address = EntityGenerator.getAddress();
		
		//mock the repository call
		when(addressRepository.save(address)).thenReturn(address);
		
		// call the service method
		Address savedAddress = addressService.saveAddress(address);
		
		// verify the results
		assertEquals(address.getDoorNo(), savedAddress.getDoorNo());
		assertEquals(address.getAddressLine1(), savedAddress.getAddressLine1());
		assertEquals(address.getAddressLine2(), savedAddress.getAddressLine2());
		assertEquals(address.getTaluk(), savedAddress.getTaluk());
		assertEquals(address.getDistrict(), savedAddress.getDistrict());
		assertEquals(address.getCountry(), savedAddress.getCountry());
		assertEquals(address.getState(), savedAddress.getState());
		assertEquals(address.getPincode(), savedAddress.getPincode());
	}
	
	@Test
	public void test_saveAllAddresses() {
		List<Address> addressList = EntityGenerator.getAddressList();
		
		//mock the repository call
		when(addressRepository.saveAll(addressList)).thenReturn(addressList);
		
		// call the service method
		List<Address> savedAddressList = addressService.saveAllAddresses(addressList);
		
		//verify the results
		assertEquals(addressList.size(), savedAddressList.size());
	}
}
