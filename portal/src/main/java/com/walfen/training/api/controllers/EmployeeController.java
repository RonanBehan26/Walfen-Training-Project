package com.walfen.training.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.EmployeeDto;
import com.walfen.training.api.entities.Employee;
import com.walfen.training.api.services.EmployeeService;


@RestController
@RequestMapping("/employees") //this is a http request for this path
public class EmployeeController {
	
	@Resource
	private EmployeeService employeeService;
	
	@Resource
	private ModelMapper mapper;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDto> list() {
		
		List<Employee> employees = employeeService.list();

		return employees.stream().map( a -> mapper.map(a, EmployeeDto.class)).collect(Collectors.toList());
	}
	
	
/////////////////////////	
	@RequestMapping(path = "/filtered-and-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDto> list1() {
		
		List<Employee> employees = employeeService.list1();

		return employees.stream().map( a -> mapper.map(a, EmployeeDto.class)).collect(Collectors.toList());
	}
	
	@RequestMapping(path = "/filtered-containing-and-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDto> list2() {
		
		List<Employee> employees = employeeService.list2();

		return employees.stream().map( a -> mapper.map(a, EmployeeDto.class)).collect(Collectors.toList());
	}

///////////////////////
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDto get(@PathVariable Long id) {
		Employee employee = employeeService.get(id);

		return mapper.map(employee, EmployeeDto.class);
	}
			

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employee = employeeService.create(employee);

		return mapper.map(employee, EmployeeDto.class);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDto update(@PathVariable Long id, @RequestBody Employee employee) {
		
		employee = employeeService.update(employee);

		return mapper.map(employee, EmployeeDto.class);
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}
	
	
//	///////////////////////// Part 1	
//	@RequestMapping(value = "/filtered-and-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public EmployeeDto get(String company) {
//		Employee employee = employeeService.getCompany(company);
//
//		return mapper.map(employee, EmployeeDto.class);
//	}
//	
//	
//	///////////////////////// Part 2
//	@RequestMapping(path = "/filtered-containing-and-sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<EmployeeDto> listByCompanyContainingAndSorted(String company, String lastName) {
//		
//		List<Employee> employees = employeeService.listByCompanyContainingAndSorted(company, lastName);//returns the company without sorting, so we must set it up to sort
//
//		return employees.stream().map( a -> mapper.map(a, EmployeeDto.class)).collect(Collectors.toList());
//	}


}
