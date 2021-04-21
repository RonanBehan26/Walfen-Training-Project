package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.AddressDao;
import com.walfen.training.api.entities.Address;
import com.walfen.training.api.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {


		private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
		
		@Resource
		private AddressDao addressDao;

		@Override
		@Transactional(readOnly = true)
		public List<Address> list() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		@Transactional(readOnly = true)
		public Address get(Long id) {
			LOGGER.info("get address - id: {}", id);
			return addressDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		}


		@Override
		@Transactional
		public Address create(Address address) {
			LOGGER.info("create address");

			return addressDao.save(address);
		}

		@Override
		@Transactional
		public Address update(Address address) {
			LOGGER.info("update address - id: {}", address.getId());

			Address storedAddress = addressDao.findById(address.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
			storedAddress.setStreet(address.getStreet());
			storedAddress.setCity(address.getCity());
			storedAddress.setCountry(address.getCountry());

			return addressDao.save(storedAddress);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			LOGGER.info("delete address - id: {}", id);
			
			addressDao.deleteById(id);
			
		}
		


}