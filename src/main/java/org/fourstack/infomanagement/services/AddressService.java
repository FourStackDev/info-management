package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Address;

public interface AddressService {
	
	public List<Address> getAllAddresses();
	
	public Optional<Address> getAddressById(long id);
	
	public Address saveAddress(Address address);
	
	public List<Address> saveAllAddresses(List<Address> addressList);
}
