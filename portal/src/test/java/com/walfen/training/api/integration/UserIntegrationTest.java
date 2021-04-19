package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
public class UserIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
	
	// @Formatter:off
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testList() throws Exception {
		mvc.perform(get("/users") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$.totalElements", is(3)))
			.andExpect(jsonPath("$.content[0].id", is(1)))
			.andExpect(jsonPath("$.content[0].firstName", is("John")))
			.andExpect(jsonPath("$.content[0].lastName", is("Burke")))
			.andExpect(jsonPath("$.content[1].id", is(2)))
			.andExpect(jsonPath("$.content[1].firstName", is("Pat")))
			.andExpect(jsonPath("$.content[1].lastName", is("Glen")))
			.andExpect(jsonPath("$.content[2].id", is(3)))
			.andExpect(jsonPath("$.content[2].firstName", is("Jane")))
			.andExpect(jsonPath("$.content[2].lastName", is("Doe")));

	}
	// @Formatter:on
}
