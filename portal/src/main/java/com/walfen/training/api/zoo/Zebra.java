package com.walfen.training.api.zoo;

public class Zebra extends Animal{
	
	private String country;


	@Override
	public String getType() {
		return "Zebra";
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
