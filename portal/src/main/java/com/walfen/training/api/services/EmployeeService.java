package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Employee;


public interface EmployeeService {

	List<Employee> list();

	Employee get(Long id);

	Employee create(Employee employee);

	Employee update(Employee employee);

	void delete(Long id);

	List<Employee> listFilteredCompanySortedLastName(String company);

	List<Employee> listFilteredCompanySortedLastNameDesc(String company);
}
