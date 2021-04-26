package com.walfen.training.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;

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

	List<Employee> findAllByFirstName(String firstName);

	List<Employee> findByFirstNameContaining(String firstName);

	List<Employee> findAllById(long id);
	
	List<Employee> findAllByCompanyOrCompany(String company, String company2);

	List<Employee> findAllByFirstNameStartsWithAndCompany(String firstName, String company);

	List<Employee> findAllByLastName(String lastName);
	
	

	Long countByCompany(String company);

	Long countById(long id);

	Long countByFirstName(String firstName);

	Long countByFirstNameContains(String firstName);

	Long countByCompanyOrCompany(String company, String company2);

	Long countByCompanyAndFirstNameStartsWith(String company, String company2);

	Long countByLastName(String lastName);

	

	boolean existsByCompany(String company);

	
	
	
	

	

	

	

	
}



