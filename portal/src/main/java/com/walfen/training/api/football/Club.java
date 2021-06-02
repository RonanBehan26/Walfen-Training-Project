package com.walfen.training.api.football;

public class Club {
	
	private String name;
	private int year;
	private String president;
	private String coach;
	private int players; //number of players
	
	public Club(String name, int year, String president, String coach, int players) {
		this.name = name;
		this.year = year;
		this.president = president;
		this.coach = coach;
		this.players = players;
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

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}
	
	
	
	

}
