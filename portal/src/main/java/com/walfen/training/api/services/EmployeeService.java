package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.entities.User;

public interface EmployeeService {

	List<Employee> list();

	Employee get(Long id);

	User create(Employee employee);

	User update(Employee employee);

	void delete(Long id); 
}
