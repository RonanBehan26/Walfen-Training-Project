package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.entities.Company;
import com.walfen.training.api.services.CompanyService;

@RestController
//@RequestMapping(value={"/companies/city-sorted-desc"})
public class CompanyController {

	@Resource
	private CompanyService companyService;

	//@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/companies/name-sorted", method = RequestMethod.GET)
	public List<Company> list() {
		List<Company> companies = companyService.list();

		return companies;
	}
	
	//@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/companies/city-sorted-desc", method = RequestMethod.GET)
	public List<Company> listCity() {
		List<Company> companies = companyService.list();

		return companies;
	}

}
