package com.walfen.training.api.football;

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
		
		//(String firstName, String lastName, int birthDate, List<String> duties)
		President presidentTeam1 = new President("Pat", "Spillane", LocalDate.parse("1956-11-14"), duties, LocalDate.parse("1975-11-14") );
			
		//(String firstName, String lastName, int birthDate, int startingDate)
		Coach coachTeam1 = new Coach("John", "Burns", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));
		
		//(String firstName, String lastName, int birthDate, String position, int goals)
		Player playerT1P1 = new Player("Mike", "Halpin", LocalDate.parse("1989-11-14"), "Forward", 2);
		Player playerT1P2 = new Player("Harry", "Horan", LocalDate.parse("1993-11-14") , "Back", 0);
		Player playerT1P3 = new Player("Paul", "Comeford", LocalDate.parse("1983-12-12") , "Mid-Field", 16);
		
		//list of players
		List<Player> players =new ArrayList<Player>();
		players.add(playerT1P1);
		players.add(playerT1P2);
		players.add(playerT1P3);
			
		Club club = new Club("Johnstown", LocalDate.parse("1924-11-14") , presidentTeam1, coachTeam1, players);
			    	
	    	System.out.println("Club Name: " + club.getName());
	    	
	    	System.out.println("Year of Creation: " + club.getYear());
	    	
	    	System.out.println("President's Name: " + presidentTeam1.getFirstName() + " " + presidentTeam1.getLastName());
	    	
	    	System.out.println("Coach's Name: " + coachTeam1.getFirstName() + " " + coachTeam1.getLastName());
	    	
	    	System.out.println("Number of Players: " + players.size());
	    	
	    }

}
/*
 * 	@Test
	public void testClub(){

		//duties for the president
		List<String> duties =new ArrayList<String>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");
		
		//(String firstName, String lastName, int birthDate, List<String> duties)
		President presidentTeam1 = new President("Pat", "Spillane", 1955, duties, 1998);
			
		//(String firstName, String lastName, int birthDate, int startingDate)
		Coach coachTeam1 = new Coach("John", "Burns", 1984, 2015);
		
		//(String firstName, String lastName, int birthDate, String position, int goals)
		Player playerT1P1 = new Player("Mike", "Halpin", 1993, "Forward", 2);
		Player playerT1P2 = new Player("Harry", "Horan", 1973, "Back", 0);
		Player playerT1P3 = new Player("Paul", "Comeford", 1998, "Mid-Field", 16);
		
		//list of players
		List<Player> players =new ArrayList<Player>();
		players.add(playerT1P1);
		players.add(playerT1P2);
		players.add(playerT1P3);
			
		Club club = new Club("Johnstown", 1923, presidentTeam1, coachTeam1, players);
			    	
	    	System.out.println("Club Name: " + club.getName());
	    	
	    	System.out.println("Year of Creation: " + club.getYear());
	    	
	    	System.out.println("President's Name: " + presidentTeam1.getFirstName() + " " + presidentTeam1.getLastName());
	    	
	    	System.out.println("Coach's Name: " + coachTeam1.getFirstName() + " " + coachTeam1.getLastName());
	    	
	    	System.out.println("Number of Players: " + players.size());
	    	
	    }
	    
	    */
