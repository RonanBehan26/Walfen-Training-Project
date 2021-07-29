package com.walfen.training.api.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.walfen.training.api.football.Person;

public class PresidentDto extends PersonDto {

	private LocalDate startingDate;
	private List<String> duties;

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
