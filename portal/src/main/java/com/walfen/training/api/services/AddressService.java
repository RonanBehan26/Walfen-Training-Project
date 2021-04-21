package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Address;

public interface AddressService {

	List<Address> list();

	Address get(Long id);

	void delete(Long id);

	Address update(Address address);

	Address create(Address address);


}
