package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.EmployeeService;


@RestController
@RequestMapping("/employees") //this is a http request for this path
public class EmployeeController {
	
	@Resource
	private EmployeeService employeeService;
	
	
//step 1
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findByPosition(@PathVariable("employees") String position) {
		
	String returnValue ="PositionList";
	
	List<Employee> employee = employeeService.findByOrderByPosition();

		return returnValue;
	
	}

	
//	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Employee> list() {
//
//		return employeeService.list();
//	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee get(@PathVariable Long id) {

		return employeeService.get(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee create(@RequestBody Employee employee) {

		return employeeService.create(employee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {

		return employeeService.update(employee);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}


}
