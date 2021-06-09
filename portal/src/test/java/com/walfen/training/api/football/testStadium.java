package com.walfen.training.api.football;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@AutoConfigureMockMvc
public class testStadium {
	
	@Test
	public void testStadium(){
	
	Address addressOne = new Address("Place de Verdun", "Paris", "France");
	
//	Player playerT1P1 = new Player("Mike", "Halpin", LocalDate.parse("1989-11-14"), "Forward", 2);
//	List<Player> players =new ArrayList<Player>();
//	players.add(playerT1P1);
	
	Seat seatOne = new Seat(1, 1, 1);
	Seat seatTwo = new Seat(2, 2, 2);
	Seat seatThree = new Seat(3, 3, 3);
	
	List<Seat> seats = new ArrayList<Seat>();
	seats.add(seatOne);
	seats.add(seatTwo);
	seats.add(seatThree);
	
	List<String> dutiesTest = new ArrayList<String>();
	dutiesTest.add("Finances");
	dutiesTest.add("Ads");
	dutiesTest.add("Raffle");
	
	President presidentTeamTest = new President("Pat", "Dunbarr", LocalDate.parse("1956-11-14"), LocalDate.parse("1975-11-14"), dutiesTest);
	
	Coach coachTeamTest = new Coach("John", "Pine", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));
	
	
	
	Player playerT1P1Test = new Player("Mike", "Testman", LocalDate.parse("1989-11-14"), "Forward", 2);
	Player playerT1P2Test = new Player("Harry", "Testerman", LocalDate.parse("1993-11-14"), "Back", 0);
	Player playerT1P3Test = new Player("Paul", "Testford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);
	
	List<Player> playersTest =new ArrayList<Player>();
	playersTest.add(playerT1P1Test);
	playersTest.add(playerT1P2Test);
	playersTest.add(playerT1P3Test);
	
	Club clubTest = new Club("JohnsVille", LocalDate.parse("1924-11-14") , presidentTeamTest, coachTeamTest, playersTest);
	
	
	Stadium stadium = new Stadium("Stade de France", LocalDate.parse("1889-11-14"), addressOne, seats, clubTest);
	
	assertEquals("Stade de France", stadium.getName());
	assertEquals(LocalDate.parse("1889-11-14"), stadium.getYear());
	assertEquals(addressOne, stadium.getAddress());
	assertEquals(seats, stadium.getSeats());
	assertEquals(clubTest, stadium.getClub());
	
	
	
	}
}
