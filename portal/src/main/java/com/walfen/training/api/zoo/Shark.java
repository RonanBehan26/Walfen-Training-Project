package com.walfen.training.api.zoo;

public class Shark extends Animal implements Carnivore {

	public String ocean;

	@Override
	public String getType() {
		return "Shark";
	}

	public Shark(String ocean) {
		super();
		this.ocean = ocean;
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
