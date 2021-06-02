package com.walfen.training.api.football;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class President extends Person {
	
	List<String> duties;
	private int startingDate;
	
	public President(String firstName, String lastName, int birthDate, List<String> duties) {
		super(firstName, lastName, birthDate);
		this.duties = new ArrayList();
		this.startingDate = startingDate;
	}
	
	

	public List<String> getDuties() {
		return duties;
	}

	public void setDuties(List<String> duties) {
		this.duties = duties;
	}

	public int getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(int startingDate) {
		this.startingDate = startingDate;
	}

}
