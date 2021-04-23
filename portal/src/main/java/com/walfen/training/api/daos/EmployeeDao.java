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
}



