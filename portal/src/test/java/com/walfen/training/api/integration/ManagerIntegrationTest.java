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
public class ManagerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
	
	@Test
	@Sql(scripts = { "classpath:db/sql/all.sql" })
	public void testList() throws Exception {
		mvc.perform(get("/managers") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].firstName", is("Pipa")))			
			.andExpect(jsonPath("$[0].lastName", is("Devlin")))
			.andExpect(jsonPath("$[0].company", is("PwC")))
			.andExpect(jsonPath("$[0].birthday", is("1978-11-22 13:23:44")))
			
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].firstName", is("Joe")))
			.andExpect(jsonPath("$[1].lastName", is("Keogh")))
			.andExpect(jsonPath("$[1].company", is("Microsoft")))
			.andExpect(jsonPath("$[1].birthday", is("1995-12-15 14:23:44")))
			
			.andExpect(jsonPath("$[2].id", is(3)))
			.andExpect(jsonPath("$[2].firstName", is("Tom")))
			.andExpect(jsonPath("$[2].lastName", is("Rourke")))
			.andExpect(jsonPath("$[2].company", is("Tesla")))
			.andExpect(jsonPath("$[2].birthday", is("1986-08-11 15:23:44")));
	}
	
//	@Test
//	@Sql(scripts = { "classpath:db/sql/all.sql" })
//	public void testGet() throws Exception {
//		mvc.perform(get("/managers/{id}", 1) //this is the api endpoint to be called
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$.id", is(1)))
//			.andExpect(jsonPath("$.street", is("Cahirdown")))
//			.andExpect(jsonPath("$.city", is("Listowel")))
//			.andExpect(jsonPath("$.country", is("Ireland")));
//	}
//	
//	
//	@Test
//	@Sql(scripts = { "classpath:db/sql/all.sql" })
//	public void testCreate() throws Exception {
//		Address address = new Address();
//		address.setStreet("BagEnd");
//		address.setCity("Shire");
//		address.setCountry("MiddleEarth");
//
//		mvc.perform(post("/managers")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(objectMapper.writeValueAsString(address)))
//			.andExpect(status().isCreated())
//			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$.id").exists()) //id assigned, that it exists
//			.andExpect(jsonPath("$.street", is("BagEnd")))//You are verifying the above here
//			.andExpect(jsonPath("$.city", is("Shire")))
//			.andExpect(jsonPath("$.country", is("MiddleEarth")));
//	}
//	
//	@Test
//	@Sql(scripts = { "classpath:db/sql/all.sql" })
//	public void testUpdate() throws Exception {
//		Address address = new Address();
//		address.setId(1);
//		address.setStreet("Dromin");
//		address.setCity("Tralee");
//		address.setCountry("Ireland");
//
//		mvc.perform(put("/managers/{id}", address.getId())
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(objectMapper.writeValueAsString(address)))
//			.andExpect(status().isOk())
//			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$.id", is(1)))
//			.andExpect(jsonPath("$.street", is("Dromin")))//verifying the above
//			.andExpect(jsonPath("$.city", is("Tralee")))
//			.andExpect(jsonPath("$.country", is("Ireland")));
//	}
//	
//	// @formatter:on
//	
//	@Test
//	@Sql(scripts = { "classpath:db/sql/all.sql" })
//	public void testDelete() throws Exception {
//		
//		mvc.perform(delete("/managers/{id}", 1))
//			.andExpect(status().isNoContent());	
//	}

} 
