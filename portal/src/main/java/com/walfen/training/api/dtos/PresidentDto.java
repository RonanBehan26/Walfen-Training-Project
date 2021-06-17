package com.walfen.training.api.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.walfen.training.api.football.Person;

public class PresidentDto extends PersonDto {

	private LocalDate startingDate;
	private List<String> duties;

	public PresidentDto(String firstName, String lastName, LocalDate birthDate) {
		super(firstName, lastName, birthDate);// calls the superclass constructor
		this.duties = new ArrayList<>();
	}

	public PresidentDto(String firstName, String lastName, LocalDate birthDate, LocalDate startingDate,
			List<String> duties) {
		this(firstName, lastName, startingDate);// calls the constructor above
		this.startingDate = startingDate;
		this.duties = duties;
	}

	public List<String> getDuties() {
		return duties;
	}

	public void setDuties(List<String> duties) {
		this.duties = duties;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

}
