package com.walfen.training.api.football;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@AutoConfigureMockMvc
public class testStadium {

	@Test
	public void testStadium() {

		Address addressOne = new Address("Place de Verdun", "Paris", "France");

		Seat seatOne = new Seat(1, 1, 1);
		Seat seatTwo = new Seat(2, 2, 2);
		Seat seatThree = new Seat(3, 3, 3);

		List<Seat> seats = new ArrayList<>();
		seats.add(seatOne);
		seats.add(seatTwo);
		seats.add(seatThree);

		List<String> dutiesTest = new ArrayList<String>();
		dutiesTest.add("Finances");
		dutiesTest.add("Ads");
		dutiesTest.add("Raffle");

		President presidentTeamTest = new President("Pat", "Dunbarr", LocalDate.parse("1956-11-14"),
				LocalDate.parse("1975-11-14"), dutiesTest);

		Coach coachTeamTest = new Coach("John", "Pine", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

		Player playerT1P1Test = new Player("Mike", "Testman", LocalDate.parse("1989-11-14"), "Forward", 2);

		Player playerT1P2Test = new Player("Harry", "Testerman", LocalDate.parse("1993-11-14"), "Back", 0);

		Player playerT1P3Test = new Player("Paul", "Testford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);

		List<Player> playersTest = new ArrayList<Player>();
		playersTest.add(playerT1P1Test);
		playersTest.add(playerT1P2Test);
		playersTest.add(playerT1P3Test);

		Club clubTest = new Club("JohnsVille", LocalDate.parse("1924-11-14"), presidentTeamTest, coachTeamTest,
				playersTest);

		Stadium stadium = new Stadium("Stade de France", LocalDate.parse("1889-11-14"), addressOne, seats, clubTest);

		assertEquals("Stade de France", stadium.getName());
		assertEquals(LocalDate.parse("1889-11-14"), stadium.getYear());

		// Club name
		assertEquals("JohnsVille", stadium.getClub().getName());

		// Address Properties
		assertEquals("Place de Verdun", stadium.getAddress().getStreet());
		assertEquals("Paris", stadium.getAddress().getCity());
		assertEquals("France", stadium.getAddress().getCountry());

		// All of the seats
		assertEquals(1, stadium.getSeats().get(0).getNumber());
		assertEquals(1, stadium.getSeats().get(0).getRow());
		assertEquals(1, stadium.getSeats().get(0).getColumn());

		assertEquals(2, stadium.getSeats().get(1).getNumber());
		assertEquals(2, stadium.getSeats().get(1).getRow());
		assertEquals(2, stadium.getSeats().get(1).getColumn());

		assertEquals(3, stadium.getSeats().get(2).getNumber());
		assertEquals(3, stadium.getSeats().get(2).getRow());
		assertEquals(3, stadium.getSeats().get(2).getColumn());

		assertEquals(addressOne, stadium.getAddress());
		assertEquals(seats, stadium.getSeats());
		assertEquals(clubTest, stadium.getClub());

	}

	@Test
	public void testListPlayerNames() {

		Player playerOne = new Player("Jake", "Tubert", LocalDate.parse("1998-11-14"), "Striker", 1);

		Player playerTwo = new Player("Harold", "MacMillan", LocalDate.parse("1997-11-14"), "Center Back", 7);

		Player playerThree = new Player("Peter", "Williams", LocalDate.parse("1996-12-12"), "Mid-Field", 16);

		List<Player> playersList = new ArrayList<Player>();
		playersList.add(playerOne);
		playersList.add(playerTwo);
		playersList.add(playerThree);

		// Creating a list of player names
		List<String> playerNames = new ArrayList<>();
		// for loop
//		for(int i=0; i<= playersList.size() - 1; i++) {
//		playerNames.add(playersList.get(i).getFirstName() + " " + playersList.get(i).getLastName());
//		}

		// lambda
		playersList.forEach((e) -> {
			playerNames.add((e).getFirstName() + " " + (e).getLastName());
		});

		List<String> dutiesListowelPresident = new ArrayList<String>();
		dutiesListowelPresident.add("Finances");
		dutiesListowelPresident.add("Ads");
		dutiesListowelPresident.add("Raffle");

		President presidentListowel = new President("Shane", "Patrick", LocalDate.parse("1982-11-14"),
				LocalDate.parse("1975-11-14"), dutiesListowelPresident);

		Coach coachListowel = new Coach("Jimmy", "McGee", LocalDate.parse("1972-12-19"), LocalDate.parse("1995-01-10"));

		Club clubListowel = new Club("Listowel", LocalDate.parse("1967-11-14"), presidentListowel, coachListowel,
				playersList);

		// Club details
		assertEquals("Listowel", clubListowel.getName());
		assertEquals(LocalDate.parse("1967-11-14"), clubListowel.getYear());
		assertEquals(presidentListowel, clubListowel.getPresident());
		assertEquals(coachListowel, clubListowel.getCoach());
		assertEquals(playersList, clubListowel.getPlayers());

		// Player names
		assertEquals("Jake Tubert", (clubListowel.getPlayers().get(0).getFirstName() + " "
				+ clubListowel.getPlayers().get(0).getLastName()));
		assertEquals("Harold MacMillan", (clubListowel.getPlayers().get(1).getFirstName() + " "
				+ clubListowel.getPlayers().get(1).getLastName()));
		assertEquals("Peter Williams", (clubListowel.getPlayers().get(2).getFirstName() + " "
				+ clubListowel.getPlayers().get(2).getLastName()));

		// Players names in the list playerNames
		assertEquals("Jake Tubert", playerNames.get(0));
		assertEquals("Harold MacMillan", playerNames.get(1));
		assertEquals("Peter Williams", playerNames.get(2));

	}
}
