package com.walfen.training.api.football;

public class Coach extends Person{
	
	private int startingDate;
	private String previousClub;
	
	public Coach(String firstName, String lastName, int birthDate, int startingDate, String previousClub) {
		super(firstName, lastName, birthDate);
		this.startingDate = startingDate;
		this.previousClub = previousClub;
	}

	public int getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(int startingDate) {
		this.startingDate = startingDate;
	}

	public String getPreviousClub() {
		return previousClub;
	}

	public void setPreviousClub(String previousClub) {
		this.previousClub = previousClub;
	}
	
	
	
	

}
