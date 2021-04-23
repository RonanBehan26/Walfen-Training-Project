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
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByPosition() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByPosition();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// TODO: create test order by first name
	// TODO: create test order by last name
	// TODO: create test order by company
	// TODO: create test order by id
	
	// TODO: create test order by position descending
	// TODO: create test order by first name descending
	// TODO: create test order by last name descending
	// TODO: create test order by company descending
	// TODO: create test order by id descending

}
