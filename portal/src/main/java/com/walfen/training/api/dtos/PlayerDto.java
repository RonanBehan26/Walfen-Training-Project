package com.walfen.training.api.dtos;

import java.time.LocalDate;

import com.walfen.training.api.football.Person;

public class PlayerDto extends PersonDto {

	private String position;
	private int goals;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

}
