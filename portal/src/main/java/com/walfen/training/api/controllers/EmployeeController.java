package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.EmployeeService;


@RestController
@RequestMapping("/employees") //this is a http request for this path
public class EmployeeController {
	
	@Resource
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> list() {

		return employeeService.list();
	}


}
