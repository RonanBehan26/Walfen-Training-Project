package com.walfen.training.api.football;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class President extends Person {
	
	private LocalDate startingDate;
	private List<String> duties;
	
	public President() {
		super();//calls the superclass constructor
		this.duties = new ArrayList<>();
	}
	
	public President(String firstName, String lastName, LocalDate birthDate, LocalDate startingDate, List<String> duties) {
		this();//calls the constructor above	
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
