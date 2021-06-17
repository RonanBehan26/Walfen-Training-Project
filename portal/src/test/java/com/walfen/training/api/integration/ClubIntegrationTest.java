package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walfen.training.api.dtos.PlayerDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ClubIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
			
	@Test
	public void testList() throws Exception {
		mvc.perform(get("/clubs") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Johnstown")))
			.andExpect(jsonPath("$[0].year", is("1924-11-14")))
			.andExpect(jsonPath("$[0].president.firstName", is("Pat")))
			.andExpect(jsonPath("$[0].coach.firstName", is("John")))
			.andExpect(jsonPath("$[0].players", hasSize(3)))
			
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Billystown")))
			.andExpect(jsonPath("$[1].year", is("1944-11-14")))
			.andExpect(jsonPath("$[1].president.firstName", is("Jake")))
			.andExpect(jsonPath("$[1].coach.firstName", is("Jim")))
			.andExpect(jsonPath("$[1].players", hasSize(3)))
			
			.andExpect(jsonPath("$[2].id", is(3)))
			.andExpect(jsonPath("$[2].name", is("Patstown")))
			.andExpect(jsonPath("$[2].year", is("1914-11-14")))
			.andExpect(jsonPath("$[2].president.firstName", is("Pat")))
			.andExpect(jsonPath("$[2].coach.firstName", is("Joe")))
			.andExpect(jsonPath("$[2].players", hasSize(3)))
			.andDo(MockMvcResultHandlers.print()); //if in doubt, read this prompt in the console
				
	}
	
	@Test
	public void testGet() throws Exception {
		mvc.perform(get("/clubs/{id}", 1) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name", is("Johnstown")))
			.andExpect(jsonPath("$.year", is("1924-11-14")))
			.andExpect(jsonPath("$.president.firstName", is("Pat")))
			.andExpect(jsonPath("$.coach.firstName", is("John")))
			.andExpect(jsonPath("$.players", hasSize(3)))
			.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testGetPlayers() throws Exception {
		mvc.perform(get("/clubs/{id}/players", 0) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			//.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].firstName", is("Tony")))
			.andExpect(jsonPath("$[0].lastName", is("Johnson")))
			.andExpect(jsonPath("$[0].birthDate", is("1989-11-14")))
			.andExpect(jsonPath("$[0].position", is("Back")))
			.andExpect(jsonPath("$[0].goals", is(18)))
			
			.andExpect(jsonPath("$[1].firstName", is("John")))
			.andExpect(jsonPath("$[1].lastName", is("Patrick")))
			.andExpect(jsonPath("$[1].birthDate", is("1989-11-14")))
			.andExpect(jsonPath("$[1].position", is("Forward")))
			.andExpect(jsonPath("$[1].goals", is(10)))
																   
			.andDo(MockMvcResultHandlers.print());
	}
		
}
