package com.walfen.training.api.dtos;

import java.util.ArrayList;
import java.util.List;

import com.walfen.training.api.zoo.Animal;

public class ZooDto {
	private long id;
	private String name;
	private String city;
	private List<AnimalDto> animals;

	public List<AnimalDto> getAnimals() {
		return this.animals;
	}

	public int getAnimalsSize() {
		return this.animals.size();
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnimals(List<AnimalDto> animals) {
		this.animals = animals;
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
