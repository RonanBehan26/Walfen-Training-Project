package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Employee;


public interface EmployeeService {

	//attempts
	//List<Employee> list();
	//List<Employee> findByOrderByPosition(String position);

	Employee get(Long id);

	Employee create(Employee employee);

	Employee update(Employee employee);

	void delete(Long id);

	//step 2
	List<Employee> findByOrderByPosition(String position); 
}
