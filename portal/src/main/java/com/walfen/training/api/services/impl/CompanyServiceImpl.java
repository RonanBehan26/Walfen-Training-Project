package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.CompanyDao;
import com.walfen.training.api.entities.Company;
import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Resource
	private CompanyDao companyDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Company> list() {
		LOGGER.info("List Companies");

		return companyDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> listByNameSorted() {
		LOGGER.info("Sort Companies by name");

		return companyDao.findAllByOrderByName();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Company> listByCitySorted() {
		LOGGER.info("Sort by city Desc");

		return companyDao.findAllByOrderByCityDesc();
	}

	@Override
	@Transactional (readOnly = true)
	//public Company getCityMadrid(String city) 
	public List<Company> listByCity(String searchText){
		// TODO Auto-generated method stub
		LOGGER.info("get company - city: {}");
		
		return companyDao.findAllByCity("Madrid");
	}

	//List<Company> findAllByCity(String city);
//	@Override
//	@Transactional
//	public Employee get(Long id) {
//		LOGGER.info("get employee - id: {}", id);
//		return employeeDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
//	}
	
	



}
