package com.walfen.training.api.entities;

public class Shark extends Animal implements Carnivore {
	
	public String ocean;
	
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return ("Shark");
	}


	public void swim() {
		System.out.println("swimming");
	}
	

	@Override
	public void hunt() {
		System.out.println("hunting in the water");
		
	}

	
	public String getOcean() {
		return ocean;
	}


	public void setOcean(String ocean) {
		this.ocean = ocean;
	}

}
