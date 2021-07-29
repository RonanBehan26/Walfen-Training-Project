package com.walfen.training.api.football;

import java.time.LocalDate;

import com.walfen.training.api.entities.Club;

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