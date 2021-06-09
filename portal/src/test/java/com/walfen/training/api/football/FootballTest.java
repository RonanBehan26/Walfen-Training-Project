package com.walfen.training.api.football;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc
public class FootballTest {
	
	@Test
	public void testClub(){

		//duties for the president
		List<String> duties =new ArrayList<String>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");
		
		President presidentTeam1 = new President("Pat", "Spillane", LocalDate.parse("1956-11-14"), LocalDate.parse("1975-11-14"), duties);
			
		Coach coachTeam1 = new Coach("John", "Burns", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));
		
		Player playerT1P1 = new Player("Mike", "Halpin", LocalDate.parse("1989-11-14"), "Forward", 2);
		Player playerT1P2 = new Player("Harry", "Horan", LocalDate.parse("1993-11-14"), "Back", 0);
		Player playerT1P3 = new Player("Paul", "Comeford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);
		
		//String firstName, String lastName, LocalDate birthDate, String position, int goals
		
		//list of players
		List<Player> players =new ArrayList<Player>();
		players.add(playerT1P1);
		players.add(playerT1P2);
		players.add(playerT1P3);
			
		Club club = new Club("Johnstown", LocalDate.parse("1924-11-14") , presidentTeam1, coachTeam1, players);
			    	
	    	System.out.println("Club Name: " + club.getName());
	    	System.out.println("Year of Creation: " + club.getYear());
	    
	    	assertEquals("Johnstown", club.getName());
	    	assertEquals(LocalDate.parse("1924-11-14"), club.getYear());
	    	assertEquals(presidentTeam1, club.getPresident());
	    	assertEquals(coachTeam1, club.getCoach());
	    	assertEquals(players, club.getPlayers());
	    	
	    	assertEquals("Pat Spillane", (club.getPresident().getFirstName() + " " + club.getPresident().getLastName()));
	    	System.out.println("President's Name: " + (club.getPresident().getFirstName() + " " + club.getPresident().getLastName()));
	    	
	    	assertEquals("John Burns", (club.getCoach().getFirstName() + " " + club.getCoach().getLastName()));
	    	System.out.println("Coach's Name: " + club.getCoach().getFirstName() + " " + club.getCoach().getLastName());
	    	
	    	assertEquals(3, club.getPlayers().size());
	    	System.out.println("Number of Players: " + club.getPlayers().size());
	    		    	
	    	//playerT1P1
	    	assertEquals("Mike", club.getPlayers().get(0).getFirstName());
	    	assertEquals("Halpin", club.getPlayers().get(0).getLastName());
	    	assertEquals(LocalDate.parse("1989-11-14"), club.getPlayers().get(0).getBirthDate());
	    	assertEquals("Forward", club.getPlayers().get(0).getPosition());
	    	assertEquals(2, club.getPlayers().get(0).getGoals());
	    	
	    	//playerT1P2
	    	assertEquals("Harry", club.getPlayers().get(1).getFirstName());
	    	assertEquals("Horan", club.getPlayers().get(1).getLastName());
	    	assertEquals(LocalDate.parse("1993-11-14"), club.getPlayers().get(1).getBirthDate());
	    	assertEquals("Back", club.getPlayers().get(1).getPosition());
	    	assertEquals(0, club.getPlayers().get(1).getGoals());
	    	
	    	//playerT1P3
	    	assertEquals("Paul", club.getPlayers().get(2).getFirstName());
	    	assertEquals("Comeford", club.getPlayers().get(2).getLastName());
	    	assertEquals(LocalDate.parse("1983-12-12"), club.getPlayers().get(2).getBirthDate());
	    	assertEquals("Mid-Field", club.getPlayers().get(2).getPosition());
	    	assertEquals(16, club.getPlayers().get(2).getGoals());
	    	
	    }

}