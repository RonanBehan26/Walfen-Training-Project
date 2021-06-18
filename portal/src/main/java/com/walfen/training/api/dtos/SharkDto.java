package com.walfen.training.api.dtos;

public class SharkDto extends AnimalDto implements CarnivoreDto {

	public String ocean;

	@Override
	public String getType() {
		return "Shark";
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
