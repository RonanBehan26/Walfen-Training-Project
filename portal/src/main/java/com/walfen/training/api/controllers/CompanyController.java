package com.walfen.training.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.daos.CompanyDao;
import com.walfen.training.api.dtos.CompanyDto;
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

	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyDto> list() {
		
		List<Company> companies = companyService.list();

		return companies.stream().map( a -> mapper.map(a, CompanyDto.class)).collect(Collectors.toList());
	}	
	
	
	
	@RequestMapping(path = "/name-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyDto> listByNameSorted() {
		
		List<Company> companies = companyService.listByNameSorted();//returns the company without sorting, so we must set it up to sort

		return companies.stream().map( a -> mapper.map(a, CompanyDto.class)).collect(Collectors.toList());
	}
	
	
	
		
	@RequestMapping(path = "/city-sorted-desc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyDto> listByCitySorted() {
		
		List<Company> companies = companyService.listByCitySorted();

		return companies.stream().map( a -> mapper.map(a, CompanyDto.class)).collect(Collectors.toList());
	}

	
	
	@RequestMapping(value = "/city-filtered", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyDto> listByCity(String city) {
		
		List<Company> companies = companyService.listByCity(city);
	
		return companies.stream().map( a -> mapper.map(a, CompanyDto.class)).collect(Collectors.toList());
		

	}
	
}
	

	


