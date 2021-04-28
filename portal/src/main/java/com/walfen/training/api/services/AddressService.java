package com.walfen.training.api.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.walfen.training.api.dtos.AddressDto;
import com.walfen.training.api.entities.Address;

public interface AddressService {

	List<Address> list();
	
	Address get(Long id);
	
	Address create(Address address);
	
	Address update(Address address);

	void delete(Long id);
	

	Page<Address> list(Boolean addressDto);

	AddressDto get(AddressDto addressDto);

	AddressDto create(AddressDto addressDto);

	AddressDto update(AddressDto addressDto);

	void delete(AddressDto addressDto);




}
