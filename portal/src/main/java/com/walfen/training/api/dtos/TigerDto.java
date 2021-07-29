package com.walfen.training.api.dtos;

public class TigerDto extends AnimalDto implements CarnivoreDto {

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
	public String getType() {
		return "Tiger";
	}

}
