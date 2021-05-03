package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walfen.training.api.daos.EmployeeDao;
import com.walfen.training.api.entities.Employee;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testList() throws Exception {
		mvc.perform(get("/employees") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(2)))
			.andExpect(jsonPath("$[0].firstName", is("Pat")))
			.andExpect(jsonPath("$[0].lastName", is("Glen")))
			.andExpect(jsonPath("$[0].company", is("Amazon")))
			.andExpect(jsonPath("$[0].position", is("Clerk")))
			.andExpect(jsonPath("$[0].dto", is(true)))
			.andExpect(jsonPath("$[1].id", is(3)))
			.andExpect(jsonPath("$[1].firstName", is("Jane")))
			.andExpect(jsonPath("$[1].lastName", is("Doe")))
			.andExpect(jsonPath("$[1].company", is("Facebook")))
			.andExpect(jsonPath("$[1].position", is("Director")))
			.andExpect(jsonPath("$[1].dto", is(true)))
			.andExpect(jsonPath("$[2].id", is(1)))
			.andExpect(jsonPath("$[2].firstName", is("John")))
			.andExpect(jsonPath("$[2].lastName", is("Burke")))
			.andExpect(jsonPath("$[2].company", is("Google")))
			.andExpect(jsonPath("$[2].position", is("Manager")))
			.andExpect(jsonPath("$[2].dto", is(true)));
		
	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testGet() throws Exception {
		mvc.perform(get("/employees/{id}", 1) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("John")))
			.andExpect(jsonPath("$.lastName", is("Burke")))
			.andExpect(jsonPath("$.company", is("Google")))
			.andExpect(jsonPath("$.position", is("Manager")))
			.andExpect(jsonPath("$.dto", is(true)));
	}

	
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCreate() throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Bill");
		employee.setLastName("Franklin");
		employee.setCompany("Twitch");
		employee.setPosition("Junior Manager");

		mvc.perform(post("/employees")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(employee)))
			.andExpect(status().isCreated())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").exists()) 
			.andExpect(jsonPath("$.firstName", is("Bill")))
			.andExpect(jsonPath("$.lastName", is("Franklin")))
			.andExpect(jsonPath("$.company", is("Twitch")))
			.andExpect(jsonPath("$.position", is("Junior Manager")))
			.andExpect(jsonPath("$.dto", is(true)));
	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testUpdate() throws Exception {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("John");
		employee.setLastName("Burke");
		employee.setCompany("Google");
		employee.setPosition("Vice President");

		mvc.perform(put("/employees/{id}", employee.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(employee)))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("John")))
			.andExpect(jsonPath("$.lastName", is("Burke")))
			.andExpect(jsonPath("$.company", is("Google")))
			.andExpect(jsonPath("$.position", is("Vice President")))
			.andExpect(jsonPath("$.dto", is(true)));
	}
	
	// @formatter:on
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testDelete() throws Exception {
		
		mvc.perform(delete("/users/{id}", 1))
			.andExpect(status().isNoContent());	
	}



/////// Part 1
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })   //Test was successful
	public void testListCompanyLastName() throws Exception {
		mvc.perform(get("/employees/filtered-and-sorted") //this is the api endpoint to be called
				.param("company", "Google")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].firstName", is("John")))
			.andExpect(jsonPath("$[0].lastName", is("Burke")))
			.andExpect(jsonPath("$[0].company", is("Google")))
			.andExpect(jsonPath("$[0].position", is("Manager")))
			.andExpect(jsonPath("$[0].dto", is(true)));
	}
	

//////////// Part 2
@Test
@Sql(scripts = { "classpath:db/sql/all.sql" })
public void testListCompanyContainsLastNameDesc() throws Exception {
	mvc.perform(get("/employees/filtered-containing-and-sorted")
			.param("company", "oo")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is(3)))
		.andExpect(jsonPath("$[0].firstName", is("Jane")))
		.andExpect(jsonPath("$[0].lastName", is("Doe")))
		.andExpect(jsonPath("$[0].company", is("Facebook")))
		.andExpect(jsonPath("$[0].position", is("Director")))
		.andExpect(jsonPath("$[0].dto", is(true)))
		.andExpect(jsonPath("$[1].id", is(1)))
		.andExpect(jsonPath("$[1].firstName", is("John")))
		.andExpect(jsonPath("$[1].lastName", is("Burke")))
		.andExpect(jsonPath("$[1].company", is("Google")))
		.andExpect(jsonPath("$[1].position", is("Manager")))
		.andExpect(jsonPath("$[1].dto", is(true)));
}


}