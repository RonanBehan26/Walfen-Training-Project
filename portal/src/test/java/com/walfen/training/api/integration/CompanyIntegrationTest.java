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
public class CompanyIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;

	// @formatter:off
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testList() throws Exception {
		mvc.perform(get("/companies/name-sorted")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Company 1")))
			.andExpect(jsonPath("$[0].city", is("Krakow")))
			.andExpect(jsonPath("$[0].dto", is(true)))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Company 2")))
			.andExpect(jsonPath("$[1].city", is("Cork")))
			.andExpect(jsonPath("$[1].dto", is(true)))
			.andExpect(jsonPath("$[2].id", is(3)))
			.andExpect(jsonPath("$[2].name", is("Company 3")))
			.andExpect(jsonPath("$[2].city", is("Madrid")))
			.andExpect(jsonPath("$[2].dto", is(true)));	
	}
	
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testListByCitySorted() throws Exception {
		mvc.perform(get("/companies/city-sorted-desc")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(3)))
			.andExpect(jsonPath("$[0].name", is("Company 3")))
			.andExpect(jsonPath("$[0].city", is("Madrid")))
			.andExpect(jsonPath("$[0].dto", is(true)))
			.andExpect(jsonPath("$[1].id", is(1)))
			.andExpect(jsonPath("$[1].name", is("Company 1")))
			.andExpect(jsonPath("$[1].city", is("Krakow")))
			.andExpect(jsonPath("$[1].dto", is(true)))
			.andExpect(jsonPath("$[2].id", is(2)))
			.andExpect(jsonPath("$[2].name", is("Company 2")))
			.andExpect(jsonPath("$[2].city", is("Cork")))
			.andExpect(jsonPath("$[2].dto", is(true)));		
	}
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testListCityMadrid() throws Exception {
		mvc.perform(get("/companies")
				.param("city", "Madrid")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].id", is(3)))
			.andExpect(jsonPath("$[0].name", is("Company 3")))
			.andExpect(jsonPath("$[0].city", is("Madrid")))
			.andExpect(jsonPath("$[0].dto", is(true)));
	}
	
	// @formatter:on
}
