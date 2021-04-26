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
	
	// Create test order by last name descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByLastNameDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByLastNameDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// Create test order by company descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByCompanyDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByCompanyDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(2).getId(), 2);
	}
	
	// Create test order by id descending, test was successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testOrderByIdDesc() throws Exception {
		List<Employee> employees = employeeDao.findAllByOrderByIdDesc();
		assertEquals(employees.size(), 3);
		assertEquals(employees.get(0).getId(), 3);
		assertEquals(employees.get(1).getId(), 2);
		assertEquals(employees.get(2).getId(), 1);
	}
	
	// Create test filter by company equals to Amazon, , test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyAmazon() throws Exception {
		List<Employee> employees = employeeDao.findAllByCompany("Amazon");
		assertEquals(employees.size(), 1);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(0).getCompany(), "Amazon");
	}
	
	
	// Create test filter by id equals to 3, test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testAllId() throws Exception {
		List<Employee> employees = employeeDao.findAllById(3);
		assertEquals(employees.size(), 1);
		assertEquals(employees.get(0).getId(), 3);
	}
	
	
	// Create test filter by first name equals to Jane, test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testFirstName() throws Exception {
		List<Employee> employees = employeeDao.findAllByFirstName("Jane");
		assertEquals(employees.size(), 1);
		assertEquals(employees.get(0).getId(), 3);
		assertEquals(employees.get(0).getFirstName(), "Jane");
	}
	
	// Create test filter by first name containing n, test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testFirstNameContainsN() throws Exception {
		List<Employee> employees = employeeDao.findByFirstNameContaining("n");
		assertEquals(employees.size(), 2);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(0).getFirstName(), "John");
		assertEquals(employees.get(1).getId(), 3);
		assertEquals(employees.get(1).getFirstName(), "Jane");
	}
	
	
	// Create test filter by company equals to Amazon or to Google, test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyAmazonORGoogle() throws Exception {
		List<Employee> employees = employeeDao.findAllByCompanyOrCompany("Amazon", "Google");
		assertEquals(employees.size(), 2);
		assertEquals(employees.get(0).getId(), 1);
		assertEquals(employees.get(0).getCompany(), "Google");
		assertEquals(employees.get(1).getId(), 2);
		assertEquals(employees.get(1).getCompany(), "Amazon");
		
	}

	 //Create test filter by company equals to Amazon and first name starting by P, test successful
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyAmazonAndP() throws Exception {
		List<Employee> employees = employeeDao.findAllByFirstNameStartsWithAndCompany("P", "Amazon");
		assertEquals(employees.size(), 1);
		assertEquals(employees.get(0).getId(), 2);
		assertEquals(employees.get(0).getFirstName(), "Pat");
		assertEquals(employees.get(0).getCompany(), "Amazon");	
	}
	
	// Create test filter by last name equals to Mary (it should return 0 results)
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testLastNameMary() throws Exception {
		List<Employee> employees = employeeDao.findAllByLastName("Mary");
		assertEquals(employees.size(), 0);

	}
	
	
	// Create test count employees filter by company equals to Google, test ok

	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyGoogleCount() throws Exception {

		Long employees = employeeDao.countByCompany("Google");
		
		assertEquals(employees, 1);
		
	}
	
	// Create test count employees filter by id equals to 1, test ok
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testIdCount() throws Exception {

		Long employees = employeeDao.countById(1);
		
		assertEquals(employees, 1);
		
	}

	
	// Create test count employees filter by first name equals to Pat, test ok
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testNamePat() throws Exception {

		Long employees = employeeDao.countByFirstName("Pat");
		
		assertEquals(employees, 1);
		
	}
	
	// TCreate test count employees filter by first name containing a, test ok
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testNameA() throws Exception {

		Long employees = employeeDao.countByFirstNameContains("a");
		
		assertEquals(employees, 2);
		
	}
	
	// Create test count employees filter by company equals to Amazon or to Facebook, test ok
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyName() throws Exception {

		Long employees = employeeDao.countByCompanyOrCompany("Amazon", "Facebook");
		
		assertEquals(employees, 2);
		
	}
	
	
	// Create test count employees filter by company equals to Facebook and first name starting by J, test ok
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyJane() throws Exception {

		Long employees = employeeDao.countByCompanyAndFirstNameStartsWith("Facebook", "J");
		
		assertEquals(employees, 1);
		
	}
	
	
	// Create test count employees filter by last name equals to Mary (it should return 0 results, test ok
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCountMary() throws Exception {

		Long employees = employeeDao.countByLastName("Mary");
		
		
		
		assertEquals(employees, 0);
		
	}
	
	
	
	
	// TODO: create test exist employees with company equals to Google
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCompanyGoogleExist() throws Exception {

		boolean employees = employeeDao.existsByCompany("Google");
		
		equals(true);
		
	}
	


	// TODO: create test exist employees with id equals to 1
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testId1Exists() throws Exception {

		boolean employees = employeeDao.existsIfId(1);
		
		equals(employees, 1);
		
	}
	// TODO: create test exist employees with first name equals to Pat
	// TODO: create test exist employees with first name containing a
	// TODO: create test exist employees with company equals to Amazon or to Facebook
	// TODO: create test exist employees with company equals to Amazon and first name starting by J
	// TODO: create test exist employees with last name equals to Mary (it should return 0 results)
	
	
	
}
