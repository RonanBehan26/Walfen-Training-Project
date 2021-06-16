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

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.zoo.Animal;
import com.walfen.training.api.zoo.Tiger;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ZooIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
			
	@Test
	public void testList() throws Exception {
		mvc.perform(get("/zoos") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Chicago Zoo")))
			.andExpect(jsonPath("$[0].city", is("Chicago")))
			.andExpect(jsonPath("$[0].animals", hasSize(3)))
			
			.andExpect(jsonPath("$[0].animals[0].name", is("Tony")))
			.andExpect(jsonPath("$[0].animals[0].type", is("Tiger")))
			
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("London Zoo")))
			.andExpect(jsonPath("$[1].city", is("London")))
			.andExpect(jsonPath("$[1].animals", hasSize(3)))
			.andExpect(jsonPath("$[2].id", is(3)))
			.andExpect(jsonPath("$[2].name", is("Madrid Zoo")))
			.andExpect(jsonPath("$[2].city", is("Madrid")))
			.andExpect(jsonPath("$[2].animals", hasSize(3)))
			.andDo(MockMvcResultHandlers.print()); //if in doubt, read this prompt in the console
		
	}
		
		@Test
		public void testGet() throws Exception {
			mvc.perform(get("/zoos/{id}", 1) //this is the api endpoint to be called
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Chicago Zoo")))
				.andExpect(jsonPath("$.city", is("Chicago")))
				.andExpect(jsonPath("$.animals[0].name", is("Tony")))
				;

	}
		
		@Test
		public void testGetAnimals() throws Exception {
			mvc.perform(get("/zoos/{id}/animals", 1) //this is the api endpoint to be called
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Chicago Zoo")))
				.andExpect(jsonPath("$.city", is("Chicago")))
				.andExpect(jsonPath("$.animals", hasSize(3)))
				.andExpect(jsonPath("$.animals[0].name", is("Tony")))
				.andExpect(jsonPath("$.animals[0].type", is("Tiger")))
				.andExpect(jsonPath("$.animals[1].name", is("John")))
				.andExpect(jsonPath("$.animals[1].type", is("Tiger")))
				.andExpect(jsonPath("$.animals[2].name", is("Pat")))
				.andExpect(jsonPath("$.animals[2].type", is("Tiger")));
			
		}

}
