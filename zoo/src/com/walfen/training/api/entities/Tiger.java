package com.walfen.training.api.entities;

public class Tiger extends Animal implements Carnivore {

	private String name;
	
	public void run() {
		System.out.println("running");
	}
	
	@Override
	public void hunt() {
		System.out.println("hunting in the forest");
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	String getType() {
		// TODO Auto-generated method stub
		return ("Tiger");
	}

}
