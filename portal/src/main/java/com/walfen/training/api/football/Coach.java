package com.walfen.training.api.football;

import java.time.LocalDate;

public class Coach extends Person{
	
	private LocalDate startingDate;
	private Club previousClub;
	
	public Coach(String firstName, String lastName, LocalDate birthDate, LocalDate startingDate) {
		super(firstName, lastName, birthDate);
		this.startingDate = startingDate;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public Club getPreviousClub() {
		return previousClub;
	}

	public void setPreviousClub(Club previousClub) {
		this.previousClub = previousClub;
	}

}

/*
 * private int startingDate;
	private Club previousClub;
	
	public Coach(String firstName, String lastName, int birthDate, int startingDate) {
		super(firstName, lastName, birthDate);
		this.startingDate = startingDate;
	}

	public int getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(int startingDate) {
		this.startingDate = startingDate;
	}

	public Club getPreviousClub() {
		return previousClub;
	}

	public void setPreviousClub(Club previousClub) {
		this.previousClub = previousClub;
	}
	*/
