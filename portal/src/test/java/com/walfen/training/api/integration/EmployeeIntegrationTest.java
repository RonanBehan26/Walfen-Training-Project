package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
			.andExpect(jsonPath("$.totalElements", is(2)))
			.andExpect(jsonPath("$.[0].company", is("Google")))
			.andExpect(jsonPath("$.[0].position", is("Manager")))
			.andExpect(jsonPath("$.[1].company", is("Amazon")))
			.andExpect(jsonPath("$.[1].position", is("Clerk")));
	}

} 