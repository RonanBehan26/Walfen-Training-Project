package com.walfen.training.api.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.walfen.training.api.football.Coach;
import com.walfen.training.api.football.Player;
import com.walfen.training.api.football.President;

public class ClubDto {

	private int id;
	private String name;
	private LocalDate year;
	private President president;
	private Coach coach;
	private List<PlayerDto> players;

	public ClubDto() {
		super();
		this.players = new ArrayList<>();
	}

	public ClubDto(int id, String name, LocalDate year, President president, Coach coach, List<PlayerDto> players) {
		this();// calls the constructor above
		this.id = id;
		this.name = name;
		this.year = year;
		this.president = president;
		this.coach = coach;
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
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

	public List<PlayerDto> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDto> players) {
		this.players = players;
	}

}
