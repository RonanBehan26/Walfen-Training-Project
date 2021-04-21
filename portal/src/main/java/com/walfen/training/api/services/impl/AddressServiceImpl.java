package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
		


}