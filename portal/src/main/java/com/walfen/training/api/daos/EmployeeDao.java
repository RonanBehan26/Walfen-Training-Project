package com.walfen.training.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

	
	//step 4
	//List<Employee> findByOrderByPosition(String position);

	

	//1(Sort By)
	List<Employee> findAllByOrderByPosition();
}



