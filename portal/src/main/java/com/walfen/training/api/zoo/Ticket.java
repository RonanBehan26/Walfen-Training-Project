package com.walfen.training.api.zoo;

import java.time.LocalDateTime;

public class Ticket {

	private LocalDateTime visitTime;
	private int numOfTickets;
	private double price;

	public Ticket(LocalDateTime visitTime, int numOfTickets, double price) {
		this.visitTime = visitTime;
		this.numOfTickets = numOfTickets;
		this.price = price;
	}

	public LocalDateTime getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(LocalDateTime visitTime) {
		this.visitTime = visitTime;
	}

	public double getPrice() {
		return price;
	}

	public int getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
