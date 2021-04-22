package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.walfen.training.api.daos.EmployeeDao;
import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Resource
	private EmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> list() {
		LOGGER.info("list employees");

		return employeeDao.findAll();
	}

}
