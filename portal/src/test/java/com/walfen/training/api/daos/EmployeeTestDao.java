package com.walfen.training.api.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.walfen.training.api.entities.Employee;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeeTestDao {

	@Resource
	private EmployeeDao employeeDao;

	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCount() throws Exception {
		long total = employeeDao.count();
		assertEquals(total, 3);
	}
	
	//create test order by position, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByPosition() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByPosition();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 1);
	}

	// Create test order by first name, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByFirstName() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByFirstName();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 3);
		assertEquals(employees.get(1).getId(), 1);
		assertEquals(employees.get(2).getId(), 2);
	}
	
	// Create test order by last name, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByLastName() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByLastName();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 2);
	}
	
	// Create test order by company, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByCompany() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByCompany();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// Create test order by id, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderById() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderById();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(1).getId(), 2);
		assertEquals(employees.get(2).getId(), 3);
	}
	
	// Create test order by position descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByPositionDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByPositionDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 2);
	}
	
	// Create test order by first name descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByFirstNameDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByFirstNameDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 1);
		assertEquals(employees.get(2).getId(), 3);
	}
	
	// TODO: create test order by last name descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByLastNameDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByLastNameDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// TODO: create test order by company descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByCompanyDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByCompanyDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 2);
	}
	
	// TODO: create test order by id descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByIdDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByIdDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 3);
		assertEquals(employees.get(1).getId(), 2);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// TODO: create test filter by company equals to Amazon
	// TODO: create test filter by id equals to 3
	// TODO: create test filter by first name equals to Jane
	// TODO: create test filter by first name containing n
	// TODO: create test filter by company equals to Amazon or to Google
	// TODO: create test filter by company equals to Amazon and first name starting by P
	// TODO: create test filter by last name equals to Mary (it should return 0 results)
	
	
}
