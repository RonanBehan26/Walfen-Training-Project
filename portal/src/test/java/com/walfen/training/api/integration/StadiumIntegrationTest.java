package com.walfen.training.api.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.walfen.training.api.entities.Club;
import com.walfen.training.api.entities.Stadium;
import com.walfen.training.api.football.Address;
import com.walfen.training.api.football.Coach;
import com.walfen.training.api.football.Player;
import com.walfen.training.api.football.President;
import com.walfen.training.api.football.Seat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StadiumIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Resource
	private ObjectMapper objectMapper;
			
	//int id, String name, LocalDate year, Address address, List<Seat> seats, Club club
	//	Stadium stadium = new Stadium(1, "Stade de France", LocalDate.parse("1889-11-14"), addressOne, seats, clubTest);
	//	Stadium stadiumS2 = new Stadium(2, "Stadio Olimpico", LocalDate.parse("1901-11-14"), addressTwo, seatsS2, clubTestS2);
	
	@Test
	public void testList() throws Exception {
		mvc.perform(get("/stadiums") //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Stade de France")))
			.andExpect(jsonPath("$[0].year", is("1889-11-14")))
			.andExpect(jsonPath("$[0].address.street", is("Place de Verdun")))
			.andExpect(jsonPath("$[0].seats", hasSize(3)))
			.andExpect(jsonPath("$[0].club.name", is("JohnsVille")))

			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Stadio Olimpico")))
			.andExpect(jsonPath("$[1].year", is("1901-11-14")))
			.andExpect(jsonPath("$[1].address.street", is("Augustus Maximus")))
			.andExpect(jsonPath("$[1].seats", hasSize(3)))
			.andExpect(jsonPath("$[1].club.name", is("Roma")))
			.andDo(MockMvcResultHandlers.print()); //if in doubt, read this prompt in the console			
	}
	
	@Test
	public void testGet() throws Exception {
		mvc.perform(get("/stadiums/{id}", 1) //this is the api endpoint to be called
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.name", is("Stade de France")))
			.andExpect(jsonPath("$.year", is("1889-11-14")))
			.andExpect(jsonPath("$.address.street", is("Place de Verdun")))
			.andExpect(jsonPath("$.seats", hasSize(3)))
			.andExpect(jsonPath("$.club.name", is("JohnsVille")))
			.andDo(MockMvcResultHandlers.print());
	}
	
}

