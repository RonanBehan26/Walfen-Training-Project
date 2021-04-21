package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walfen.training.api.entities.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;

	// @formatter:off

	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testList() throws Exception {
		mvc.perform(get("/users") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].firstName", is("John")))
			.andExpect(jsonPath("$[0].lastName", is("Burke")))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].firstName", is("Pat")))
			.andExpect(jsonPath("$[1].lastName", is("Glen")))
			.andExpect(jsonPath("$[2].id", is(3)))
			.andExpect(jsonPath("$[2].firstName", is("Jane")))
			.andExpect(jsonPath("$[2].lastName", is("Doe")));

	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testGet() throws Exception {
		mvc.perform(get("/users/{id}", 1) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("John")))
			.andExpect(jsonPath("$.lastName", is("Burke")));
	}
	
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCreate() throws Exception {
		User user = new User();
		user.setFirstName("Mary");
		user.setLastName("Harty");

		mvc.perform(post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(user)))
			.andExpect(status().isCreated())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").exists()) //not sure if this is supposed to be here or not, I assume it isn't
			.andExpect(jsonPath("$.firstName", is("Mary")))
			.andExpect(jsonPath("$.lastName", is("Harty")));
	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testUpdate() throws Exception {
		User user = new User();
		user.setId(1);
		user.setFirstName("Mary");
		user.setLastName("Harty");

		mvc.perform(put("/users/{id}", user.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(user)))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("Mary")))
			.andExpect(jsonPath("$.lastName", is("Harty")));
	}
	
	// @formatter:on
}
