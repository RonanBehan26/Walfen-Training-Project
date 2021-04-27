package com.walfen.training.api.entities;

public class Zebra extends Animal implements Carnivore{
	
	private String country;


	@Override
	public void hunt() {
		// TODO Auto-generated method stub
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return ("Zebra");
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
