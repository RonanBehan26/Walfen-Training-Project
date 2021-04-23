package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Address;

public interface AddressService {

	List<Address> list();
	
	Address get(Long id);
	
	Address create(Address address);
	
	Address update(Address address);

	void delete(Long id);


}
