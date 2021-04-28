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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.AddressDto;
import com.walfen.training.api.entities.Address;
import com.walfen.training.api.services.AddressService;


@RestController
@RequestMapping("/addresses")
public class AddressController {
	
		@Resource
		private ModelMapper mapper;
	
		@Resource
		private AddressService addressService;
		
		

		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<AddressDto> list(@RequestParam Boolean addressDto) {
		Page<Address> addressPage = addressService.list(addressDto);
		
		addresses.stream().map( a -> mapper.map(a, AddressDto.class)).collect(Collectors.toList());
			
		}

		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto get(@PathVariable AddressDto addressDto) {

			return addressService.get(addressDto);
		}
		
		

		@ResponseStatus(HttpStatus.CREATED)
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto create(@RequestBody AddressDto addressDto) {

			return addressService.create(addressDto);
		}
		
		

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public AddressDto update(@RequestBody AddressDto addressDto) {

			return addressService.update(addressDto);
		}
		
		
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable AddressDto addressDto) {
			addressService.delete(addressDto);
		}
		
	}



