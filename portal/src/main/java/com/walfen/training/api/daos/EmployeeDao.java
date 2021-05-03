package com.walfen.training.api.daos;

import java.util.List;
import java.util.Optional;

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

	List<Employee> findAllByFirstName(String firstName);

	List<Employee> findByFirstNameContaining(String firstName);

	List<Employee> findAllById(long id);
	
	List<Employee> findAllByCompanyOrCompany(String company, String company2);

	List<Employee> findAllByFirstNameStartsWithAndCompany(String firstName, String company); //////////////

	List<Employee> findAllByLastName(String lastName);
	
	

	Long countByCompany(String company);

	Long countById(long id);

	Long countByFirstName(String firstName);

	Long countByFirstNameContains(String firstName);

	Long countByCompanyOrCompany(String company, String company2);

	Long countByCompanyAndFirstNameStartsWith(String company, String company2);

	Long countByLastName(String lastName);

	

	boolean existsByCompany(String company);

	boolean existsById(long id);

	boolean existsByFirstName(String firstName);

	boolean existsByFirstNameContains(String firstName);
	
	

	boolean existsByCompanyOrCompany(String company, String company2);

	boolean existsByCompanyAndFirstNameStartsWith(String company, String firstName);/////////////////

	boolean existsByLastName(String lastName);
	
	
	
	
//P1
	List<Employee> findAllByCompanyAndOrderByLastName();
	
	//P2
	//boolean existsByCompanyContainingAndOrderByLastNameDesc(String company, String firstName);


	List<Employee> existsByCompanyContainingAndOrderByLastNameDesc();
		

	////////Part 1
	//List<Employee> findAllByCompanyAndOrderByLastName(String company, String lastName);
	
	
	//boolean existsByCompanyAndOrderByLastName(String company, String lastName);
	

	//List<Employee> findAllByCompanyOrderByLastName();

	//Optional<Employee> existsByCompanyOrderByLastName(String company);

	
//	//Part2
//	List<Employee> findByCompanyContainingAndOrderByLastnameDesc(String company, String lastName);
	
	

	

	

	

	
}



