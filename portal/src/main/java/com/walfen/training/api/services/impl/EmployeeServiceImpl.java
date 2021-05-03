package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.EmployeeDao;
import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.entities.Manager;
import com.walfen.training.api.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Resource
	private EmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> list() {
		LOGGER.info("list users");

		return employeeDao.findAllByOrderByPosition();
	}	
	
	
	@Override
	@Transactional
	public Employee get(Long id) {
		LOGGER.info("get employee - id: {}", id);
		return employeeDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		LOGGER.info("create employee");

		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		LOGGER.info("update employee - id: {}", employee.getId());

		Employee storedEmployee = employeeDao.findById(employee.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		storedEmployee.setCompany(employee.getCompany());
		storedEmployee.setPosition(employee.getPosition());

		return employeeDao.save(storedEmployee);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		LOGGER.info("delete employee - id: {}", id);
		
		employeeDao.deleteById(id);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> list1(String company) {
		LOGGER.info("list Employee Companies");

		return employeeDao.findByCompanyOrderByLastName(company);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> list2(String company) {
		LOGGER.info("list Company oo & lastName");

		return employeeDao.findByCompanyContainingOrderByLastNameDesc(company);
	}
	
	
///////////// Part 1 
//@Override
//@Transactional(readOnly = true)
//public Employee getCompany(String company) {
//LOGGER.info("get company and sort by last name");
//return employeeDao.existsByCompanyOrderByLastName(company).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
//}


/////////////// Part 2
//@Override
//@Transactional(readOnly = true)
//public List<Employee> listByCompanyContainingAndSorted(String company, String lastName) {
//LOGGER.info("list by company and sort by last name");
//return employeeDao.findByCompanyContainingAndOrderByLastnameDesc(company, lastName);
//}



}
