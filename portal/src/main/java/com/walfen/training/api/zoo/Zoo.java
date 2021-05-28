package com.walfen.training.api.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	
	
	private String name;
	private String city;
	
	private List<Animal> animals = new ArrayList<>();
	
	
	
	public Zoo() {
		Zebra zebraOne = new Zebra();
		animals.add(zebraOne);
		Shark sharkOne = new Shark();
		animals.add(sharkOne);
		Shark sharkTwo = new Shark();
		animals.add(sharkTwo);
		Tiger tigerOne = new Tiger();
		animals.add(tigerOne);
		Tiger tigerTwo = new Tiger();
		animals.add(tigerTwo);
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

