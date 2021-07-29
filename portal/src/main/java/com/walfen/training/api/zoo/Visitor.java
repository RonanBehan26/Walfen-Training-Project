package com.walfen.training.api.zoo;

public class Visitor {
	
	private String firstName;
	private String lastName;
	private Ticket ticket;
	
	public Visitor(String firstName, String lastName, Ticket ticket) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ticket = ticket;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
