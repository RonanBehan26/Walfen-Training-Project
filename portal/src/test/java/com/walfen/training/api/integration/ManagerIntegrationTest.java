package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walfen.training.api.entities.Manager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ManagerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;

	// @formatter:off
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })   //Test was successful
	public void testListBirthdayDesc() throws Exception {
		mvc.perform(get("/managers") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			
			.andExpect(jsonPath("$[0].id", is(2)))
			.andExpect(jsonPath("$[0].firstName", is("Joe")))
			.andExpect(jsonPath("$[0].lastName", is("Keogh")))
			.andExpect(jsonPath("$[0].company", is("Microsoft")))
			.andExpect(jsonPath("$[0].birthday", is("1995-12-15")))
			
			.andExpect(jsonPath("$[1].id", is(3)))
			.andExpect(jsonPath("$[1].firstName", is("Tom")))
			.andExpect(jsonPath("$[1].lastName", is("Rourke")))
			.andExpect(jsonPath("$[1].company", is("Tesla")))
			.andExpect(jsonPath("$[1].birthday", is("1986-08-11")))
			
			.andExpect(jsonPath("$[2].id", is(1)))
			.andExpect(jsonPath("$[2].firstName", is("Pipa")))			
			.andExpect(jsonPath("$[2].lastName", is("Devlin")))
			.andExpect(jsonPath("$[2].company", is("PwC")))
			.andExpect(jsonPath("$[2].birthday", is("1978-11-22")));
	}
	
	@Test                                                 //Test was successful
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testGet() throws Exception {
		mvc.perform(get("/managers/{id}", 1) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("Pipa")))
			.andExpect(jsonPath("$.lastName", is("Devlin")))
			.andExpect(jsonPath("$.company", is("PwC")))
			.andExpect(jsonPath("$.birthday", is("1978-11-22")));
	}

	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testCreate() throws Exception {
		Manager manager = new Manager();
		manager.setFirstName("Bill");
		manager.setLastName("Franklin");
		manager.setCompany("Twitch");
		manager.setBirthday(LocalDate.of(1983, 9, 1));

		mvc.perform(post("/managers")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(manager)))
			.andExpect(status().isCreated())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").exists()) 
			.andExpect(jsonPath("$.firstName", is("Bill")))
			.andExpect(jsonPath("$.lastName", is("Franklin")))
			.andExpect(jsonPath("$.company", is("Twitch")))
			.andExpect(jsonPath("$.birthday", is("1983-09-01")));
	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testUpdate() throws Exception {
		Manager manager = new Manager();
		manager.setId(1);
		manager.setFirstName("John");
		manager.setLastName("Burke");
		manager.setCompany("Google");
		manager.setBirthday(LocalDate.of(1983, 9, 1));

		mvc.perform(put("/managers/{id}", manager.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(manager)))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.firstName", is("John")))
			.andExpect(jsonPath("$.lastName", is("Burke")))
			.andExpect(jsonPath("$.company", is("Google")))
			.andExpect(jsonPath("$.birthday", is("1983-09-01")));
	}
		
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testDelete() throws Exception {
		mvc.perform(delete("/users/{id}", 1))
			.andExpect(status().isNoContent());	
	}
	
	// @formatter:on
}