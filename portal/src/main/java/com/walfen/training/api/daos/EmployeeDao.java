package com.walfen.training.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

	List<Employee> findAllByOrderByPosition();

	List<Employee> findAllByOrderByFirstName();

	List<Employee> findAllByOrderByLastName();

	List<Employee> findAllByOrderByCompany();

	List<Employee> findAllByOrderById();

	List<Employee> findAllByOrderByPositionDesc();

	List<Employee> findAllByOrderByFirstNameDesc();

	List<Employee> findAllByOrderByLastNameDesc();

	List<Employee> findAllByOrderByCompanyDesc();

	List<Employee> findAllByOrderByIdDesc();

	List<Employee> findAllByCompany(String company);

	List<Employee> findAllByFirstName(String first_name);

	List<Employee> findByFirstNameContaining(String first_name);

	List<Employee> findAllById(long id);
	
	List<Employee> findAllByCompanyOrCompany(String company, String company2);

	List<Employee> findAllByFirstNameStartsWithAndCompany(String first_name, String company);

	List<Employee> findAllByLastName(String last_name);

	

	

	
}



