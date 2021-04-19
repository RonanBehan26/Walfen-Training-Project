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
@RequestMapping("/companies")
public class CompanyController {

	@Resource
	private CompanyService companyService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> list() {
		List<Company> companies = companyService.list();

		return companies;
	}

}
