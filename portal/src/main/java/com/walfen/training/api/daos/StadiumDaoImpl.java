package com.walfen.training.api.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.entities.Stadium;
import com.walfen.training.api.football.Address;
import com.walfen.training.api.football.Coach;
import com.walfen.training.api.football.Player;
import com.walfen.training.api.football.President;
import com.walfen.training.api.football.Seat;

@Component
public class StadiumDaoImpl implements StadiumDao{

	@Override
	public List<Stadium> findAll() {
		// Stadium 1

				Address addressOne = new Address("Place de Verdun", "Paris", "France");

				Seat seatOne = new Seat(1, 1, 1);
				Seat seatTwo = new Seat(2, 2, 2);
				Seat seatThree = new Seat(3, 3, 3);

				List<Seat> seats = new ArrayList<>();
				seats.add(seatOne);
				seats.add(seatTwo);
				seats.add(seatThree);

				List<String> dutiesTest = new ArrayList<>();
				dutiesTest.add("Finances");
				dutiesTest.add("Ads");
				dutiesTest.add("Raffle");

				President presidentTeamTest = new President("Pat", "Dunbarr", LocalDate.parse("1956-11-14"),
						LocalDate.parse("1975-11-14"), dutiesTest);

				Coach coachTeamTest = new Coach("John", "Pine", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

				Player playerT1P1Test = new Player("Mike", "Testman", LocalDate.parse("1989-11-14"), "Forward", 2);

				Player playerT1P2Test = new Player("Harry", "Testerman", LocalDate.parse("1993-11-14"), "Back", 0);

				Player playerT1P3Test = new Player("Paul", "Testford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);

				List<Player> playersTest = new ArrayList<>();
				playersTest.add(playerT1P1Test);
				playersTest.add(playerT1P2Test);
				playersTest.add(playerT1P3Test);

				Club clubTest = new Club(1, "JohnsVille", LocalDate.parse("1924-11-14"), presidentTeamTest, coachTeamTest,
						playersTest);

				Stadium stadium = new Stadium(1, "Stade de France", LocalDate.parse("1889-11-14"), addressOne, seats, clubTest);

				// Stadium 2

				Address addressTwo = new Address("Augustus Maximus", "Rome", "Italy");

				Seat seatOneS2 = new Seat(1, 1, 1);
				Seat seatTwoS2 = new Seat(2, 2, 2);
				Seat seatThreeS2 = new Seat(3, 3, 3);

				List<Seat> seatsS2 = new ArrayList<>();
				seatsS2.add(seatOneS2);
				seatsS2.add(seatTwoS2);
				seatsS2.add(seatThreeS2);

				List<String> dutiesTestS2 = new ArrayList<>();
				dutiesTestS2.add("Finances");
				dutiesTestS2.add("Ads");
				dutiesTestS2.add("Raffle");

				President presidentTeamTestS2 = new President("Ron", "Dun", LocalDate.parse("1966-11-14"),
						LocalDate.parse("1955-11-14"), dutiesTestS2);

				Coach coachTeamTestS2 = new Coach("Jim", "Pike", LocalDate.parse("1954-12-19"), LocalDate.parse("1973-01-10"));

				Player playerT2P1 = new Player("Mike", "Fahy", LocalDate.parse("1999-11-14"), "Forward", 1);

				Player playerT2P2 = new Player("Bob", "O'Brian", LocalDate.parse("1983-11-14"), "Back", 2);

				Player playerT2P3 = new Player("Richy", "Test", LocalDate.parse("1993-12-12"), "Mid-Field", 2);

				List<Player> playersTestS2 = new ArrayList<>();
				playersTestS2.add(playerT2P1);
				playersTestS2.add(playerT2P2);
				playersTestS2.add(playerT2P3);

				Club clubTestS2 = new Club(2, "Roma", LocalDate.parse("1922-11-14"), presidentTeamTestS2, coachTeamTestS2,
						playersTestS2);

				Stadium stadiumS2 = new Stadium(2, "Stadio Olimpico", LocalDate.parse("1901-11-14"), addressTwo, seatsS2,
						clubTestS2);

				// List of Stadiums
				List<Stadium> stadiumList = new ArrayList<>();
				stadiumList.add(stadium);
				stadiumList.add(stadiumS2);

				return stadiumList;
	}
	
	
	@Override
	public Optional<Stadium> findById(Long id) {
		Address addressOne = new Address("Place de Verdun", "Paris", "France");

		Seat seatOne = new Seat(1, 1, 1);
		Seat seatTwo = new Seat(2, 2, 2);
		Seat seatThree = new Seat(3, 3, 3);

		List<Seat> seats = new ArrayList<>();
		seats.add(seatOne);
		seats.add(seatTwo);
		seats.add(seatThree);

		List<String> dutiesTest = new ArrayList<>();
		dutiesTest.add("Finances");
		dutiesTest.add("Ads");
		dutiesTest.add("Raffle");

		President presidentTeamTest = new President("Pat", "Dunbarr", LocalDate.parse("1956-11-14"),
				LocalDate.parse("1975-11-14"), dutiesTest);

		Coach coachTeamTest = new Coach("John", "Pine", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

		Player playerT1P1Test = new Player("Mike", "Testman", LocalDate.parse("1989-11-14"), "Forward", 2);

		Player playerT1P2Test = new Player("Harry", "Testerman", LocalDate.parse("1993-11-14"), "Back", 0);

		Player playerT1P3Test = new Player("Paul", "Testford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);

		List<Player> playersTest = new ArrayList<>();
		playersTest.add(playerT1P1Test);
		playersTest.add(playerT1P2Test);
		playersTest.add(playerT1P3Test);

		Club clubTest = new Club(1, "JohnsVille", LocalDate.parse("1924-11-14"), presidentTeamTest, coachTeamTest,
				playersTest);

		Stadium stadium = new Stadium(1, "Stade de France", LocalDate.parse("1889-11-14"), addressOne, seats, clubTest);

		return Optional.ofNullable(stadium);
	}
  
}
