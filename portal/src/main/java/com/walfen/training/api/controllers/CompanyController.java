package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.EmployeeDto;
import com.walfen.training.api.entities.Company;
import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.CompanyService;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {

	@Resource
	private CompanyService companyService;
	
	@Resource
	private ModelMapper mapper;

	
	@RequestMapping(value = "/name-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> list() {
		List<Company> companies = companyService.list();

		return companies;
	}
	
	
	@RequestMapping(value = "city-sorted-desc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> listCity() {
		List<Company> companies = companyService.list();

		return companies;
	}
	
	@RequestMapping(value = "city-filtered?city=Madrid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Company get(@PathVariable String city) {
		
		
		return mapper.map(city, Company.class);
	}
	

}
