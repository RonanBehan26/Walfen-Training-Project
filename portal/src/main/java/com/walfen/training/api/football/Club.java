package com.walfen.training.api.football;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
	
	private String name;
	private int year;
	private President president;
	private Coach coach; 
	List<Player> players;
	
	public Club(String name, int year, President president, Coach coach, List<Player> players) {
		this.name = name;
		this.year = year;
		this.president = president;
		this.coach = coach;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public President getPresident() {
		return president;
	}
		
	public void setPresident(President president) {
		this.president = president;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	

}
