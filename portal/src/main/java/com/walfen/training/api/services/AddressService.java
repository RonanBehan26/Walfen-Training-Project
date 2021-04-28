package com.walfen.training.api.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.walfen.training.api.dtos.AddressDto;
import com.walfen.training.api.entities.Address;

public interface AddressService {

	List<AddressDto> list();
	
	AddressDto get(Long id);
	
	AddressDto create(Address address);
	
	AddressDto update(Address address);

	void delete(Long id);
	

}
