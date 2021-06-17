package com.walfen.training.api.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Address;
import com.walfen.training.api.football.Seat;

public class StadiumDto {

	private int id;
	private String name;
	private LocalDate year;
	private Address address;
	private List<Seat> seats;
	private Club club;

	public StadiumDto() {
		super();
		this.seats = new ArrayList<>();
	}

	public StadiumDto(int id, String name, LocalDate year, Address address, List<Seat> seats, Club club) {
		this();
		this.id = id;
		this.name = name;
		this.year = year;
		this.address = address;
		this.seats = seats;
		this.club = club;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

}
