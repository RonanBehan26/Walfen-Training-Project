package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Company;

public interface CompanyService {

	List<Company> list();
	
	List<Company> listCityDesc();

	Company get(String city);

}
