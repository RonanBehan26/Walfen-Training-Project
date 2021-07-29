package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Company;

public interface CompanyService {

	List<Company> list();
	
	List<Company> listByNameSorted();
	
	List<Company> listByCitySorted();
	
	List<Company> listByCity(String city);



}
