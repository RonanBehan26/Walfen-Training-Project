package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	}


