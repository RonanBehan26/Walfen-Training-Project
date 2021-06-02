package com.walfen.training.api.football;

public class Player extends Person{
	
	private String position;
	private int goals;
	
	public Player(String firstName, String lastName, int birthDate, String position, int goals) {
		super(firstName, lastName, birthDate);
		this.position = position;
		this.goals = goals;
	}

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
