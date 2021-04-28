package com.walfen.training.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.AddressDto;
import com.walfen.training.api.entities.Address;
import com.walfen.training.api.entities.Company;
import com.walfen.training.api.services.AddressService;


@RestController
@RequestMapping("/addresses")
public class AddressController {
	
		@Resource
		private AddressService addressService;
		
		@Resource
		private ModelMapper mapper;
		
		

		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<AddressDto> listDto() {
			
			//what the response should be
			List<AddressDto> addresses = addressService.list();

			return addresses.stream().map( a -> mapper.map(a, AddressDto.class)).collect(Collectors.toList());
		}
		
		
				
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto get(@PathVariable Long id) {

			return addressService.get(id);
		}
		
		

		@ResponseStatus(HttpStatus.CREATED)
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto create(@RequestBody Address address) {

			return addressService.create(address);
		}
		
		

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto update(@PathVariable Long id, @RequestBody Address address) {

			return addressService.update(address);
		}
		
		
		
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			addressService.delete(id);
		}
		
	}


