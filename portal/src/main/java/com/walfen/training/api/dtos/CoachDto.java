package com.walfen.training.api.dtos;

import java.time.LocalDate;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Person;

public class CoachDto extends PersonDto {

	private LocalDate startingDate;
	private ClubDto previousClub;

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public ClubDto getPreviousClub() {
		return previousClub;
	}

	public void setPreviousClub(ClubDto previousClub) {
		this.previousClub = previousClub;
	}

}
