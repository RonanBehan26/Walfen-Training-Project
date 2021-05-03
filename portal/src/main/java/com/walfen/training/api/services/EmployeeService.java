package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Employee;


public interface EmployeeService {

	List<Employee> list();

	Employee get(Long id);

	Employee create(Employee employee);

	Employee update(Employee employee);

	void delete(Long id);
	
	
	

	List<Employee> list1();

	List<Employee> list2();

//	/////////// Part 1
////	List<Employee> listByCompanyAndLastName(String company);
//	Employee getCompany(String company);
//	
//	////////// Part 2
//
//	List<Employee> listByCompanyContainingAndSorted(String company, String lastName);

}
