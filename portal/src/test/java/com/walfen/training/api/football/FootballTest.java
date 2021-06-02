package com.walfen.training.api.football;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.walfen.training.api.zoo.Zoo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class FootballTest {
	
	@Test
	public void testZoo(){
	    	Club club = new Club("EastBirkshire Rangers", 1923, "John Dillon", "Marty Bourke", 32);
	    	
	    	//String name, int year, String president, String coach, int players
	    	
	    	System.out.print("Club Name: " + club.getName() + "\n");
	    	
	    	System.out.print("Year of Creation: " + club.getYear() + "\n");
	    	
	    	System.out.print("President's Name: " + club.getPresident() + "\n");
	    	
	    	System.out.print("Coach's Name: " + club.getCoach() + "\n");
	    	
	    	System.out.print("Number of Players: " + club.getPlayers() + "\n");
	    	

	    	
	    }

}
