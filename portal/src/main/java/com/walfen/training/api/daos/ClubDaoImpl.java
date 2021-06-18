package com.walfen.training.api.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Coach;
import com.walfen.training.api.football.Player;
import com.walfen.training.api.football.President;

@Component
public class ClubDaoImpl implements ClubDao {

	@Override
	public List<Club> findAll() {
		// Team 1

		// duties for the president
		List<String> duties = new ArrayList<>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");

		President presidentTeam1 = new President("Pat", "Spillane", LocalDate.parse("1956-11-14"),
				LocalDate.parse("1975-11-14"), duties);

		Coach coachTeam1 = new Coach("John", "Burns", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

		Player playerT1P1 = new Player("Mike", "Halpin", LocalDate.parse("1989-11-14"), "Forward", 2);
		Player playerT1P2 = new Player("Harry", "Horan", LocalDate.parse("1993-11-14"), "Back", 0);
		Player playerT1P3 = new Player("Paul", "Comeford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);

		// list of players
		List<Player> playersListOne = new ArrayList<>();
		playersListOne.add(playerT1P1);
		playersListOne.add(playerT1P2);
		playersListOne.add(playerT1P3);

		Club clubOne = new Club(1, "Johnstown", LocalDate.parse("1924-11-14"), presidentTeam1, coachTeam1,
				playersListOne);

		// Club 2

		// duties for the president
		List<String> dutiesTwo = new ArrayList<>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");

		President presidentTeam2 = new President("Jake", "Spoke", LocalDate.parse("1946-11-14"),
				LocalDate.parse("1985-11-14"), dutiesTwo);

		Coach coachTeam2 = new Coach("Jim", "Buckhannon", LocalDate.parse("1974-12-19"), LocalDate.parse("1993-01-10"));

		Player playerT2P1 = new Player("Milo", "Hape", LocalDate.parse("1983-11-14"), "Forward", 6);
		Player playerT2P2 = new Player("Harold", "Harty", LocalDate.parse("1994-11-14"), "Back", 1);
		Player playerT2P3 = new Player("Pipa", "Neill", LocalDate.parse("1993-12-12"), "Mid-Field", 10);

		// list of players
		List<Player> playersListTwo = new ArrayList<>();
		playersListTwo.add(playerT2P1);
		playersListTwo.add(playerT2P2);
		playersListTwo.add(playerT2P3);

		Club clubTwo = new Club(2, "Billystown", LocalDate.parse("1944-11-14"), presidentTeam2, coachTeam2,
				playersListTwo);

		// Club 3

		// duties for the president
		List<String> dutiesThree = new ArrayList<>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");

		President presidentTeam3 = new President("Pat", "McGee", LocalDate.parse("1956-11-14"),
				LocalDate.parse("1975-11-14"), dutiesThree);

		Coach coachTeam3 = new Coach("Joe", "Dolan", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

		Player playerT3P1 = new Player("Mitch", "Smith", LocalDate.parse("1989-11-14"), "Forward", 3);
		Player playerT3P2 = new Player("Hope", "Bean", LocalDate.parse("1993-11-14"), "Back", 1);
		Player playerT3P3 = new Player("Andy", "Firy", LocalDate.parse("1983-12-12"), "Mid-Field", 0);

		// list of players
		List<Player> playersListThree = new ArrayList<>();
		playersListThree.add(playerT3P1);
		playersListThree.add(playerT3P2);
		playersListThree.add(playerT3P3);

		Club clubThree = new Club(3, "Patstown", LocalDate.parse("1914-11-14"), presidentTeam3, coachTeam3,
				playersListThree);

		// list of clubs
		List<Club> clubs = new ArrayList<>();
		clubs.add(clubOne);
		clubs.add(clubTwo);
		clubs.add(clubThree);

		return clubs;

	}

	@Override
	public Optional<Club> findById(Long id) {
		// Team 1

		// duties for the president
		List<String> duties = new ArrayList<>();
		duties.add("Finances");
		duties.add("Ads");
		duties.add("Raffle");

		President presidentTeam1 = new President("Pat", "Spillane", LocalDate.parse("1956-11-14"),
				LocalDate.parse("1975-11-14"), duties);

		Coach coachTeam1 = new Coach("John", "Burns", LocalDate.parse("1954-12-19"), LocalDate.parse("1983-01-10"));

		Player playerT1P1 = new Player("Mike", "Halpin", LocalDate.parse("1989-11-14"), "Forward", 2);
		Player playerT1P2 = new Player("Harry", "Horan", LocalDate.parse("1993-11-14"), "Back", 0);
		Player playerT1P3 = new Player("Paul", "Comeford", LocalDate.parse("1983-12-12"), "Mid-Field", 16);

		// list of players
		List<Player> playersListOne = new ArrayList<>();
		playersListOne.add(playerT1P1);
		playersListOne.add(playerT1P2);
		playersListOne.add(playerT1P3);

		Club clubOne = new Club(1, "Johnstown", LocalDate.parse("1924-11-14"), presidentTeam1, coachTeam1,
				playersListOne);

		return Optional.ofNullable(clubOne);
	}

	@Override
	public List<Player> findPlayersById(Long id) {
		List<Player> playersListOne = new ArrayList<>();

		Player playerOne = new Player("Tony", "Johnson", LocalDate.parse("1989-11-14"), "Back", 18);
		Player playerTwo = new Player("John", "Patrick", LocalDate.parse("1989-11-14"), "Forward", 10);

		playersListOne.add(playerOne);
		playersListOne.add(playerTwo);

		return playersListOne;
	}

}
