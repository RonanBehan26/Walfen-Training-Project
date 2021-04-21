package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.entities.Address;
import com.walfen.training.api.services.AddressService;


@RestController
@RequestMapping("/addresses")
public class AddressController {
	
		@Resource
		private AddressService addressService;

		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Address> list() {

			return addressService.list();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public Address get(@PathVariable Long id) {

			return addressService.get(id);
		}

		@ResponseStatus(HttpStatus.CREATED)
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Address create(@RequestBody Address address) {

			return addressService.create(address);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Address update(@PathVariable Long id, @RequestBody Address address) {

			return addressService.update(address);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			addressService.delete(id);
		}
		
	}


