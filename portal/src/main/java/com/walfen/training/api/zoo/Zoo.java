package com.walfen.training.api.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private String name;
	private String city;
	private List<Animal> animals = new ArrayList<>();

	public Zoo() {
		super();
		this.animals = new ArrayList<>();
	}

	public Zoo(String name, String city, List<Animal> animals) {
		this();
		this.name = name;
		this.city = city;
		this.animals = animals;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public int getAnimalsSize() {
		return this.animals.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
