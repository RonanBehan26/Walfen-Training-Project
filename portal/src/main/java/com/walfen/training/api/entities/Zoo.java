package com.walfen.training.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.walfen.training.api.zoo.Animal;

//@Entity
public class Zoo {

	private long id;
	private String name;
	private String city;
	private List<Animal> animals = new ArrayList<>();

	public Zoo() {
		super();
		this.animals = new ArrayList<>();
	}

	public Zoo(int id, String name, String city, List<Animal> animals) {
		this();
		this.id = id;
		this.name = name;
		this.city = city;
		this.animals = animals;
	}

	@OneToMany
	public List<Animal> getAnimals() {
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

	public void setAnimals(List<Animal> animals) {
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
