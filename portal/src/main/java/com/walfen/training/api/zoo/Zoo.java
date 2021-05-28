package com.walfen.training.api.zoo;

import java.util.LinkedList;

public class Zoo {
	
	
	private String name;
	private String city;
	
	LinkedList<Zoo> animals = new LinkedList<>();
	
	Zebra zebraOne = new Zebra();
	Shark sharkOne = new Shark();
	Shark sharkTwo = new Shark();
	Tiger tigerOne = new Tiger();
	Tiger tigerTwo = new Tiger();
	
	
	public Zoo() {
		zebraOne.setName("George");
		zebraOne.setCity("Cork");
		animals.add(zebraOne);
		
		sharkOne.setName("Pat");
		sharkOne.setCity("Madrid");
		animals.add(sharkOne);
		
		sharkTwo.setName("Johnny");
		sharkTwo.setCity("Cologne");
		animals.add(sharkTwo);
		
		tigerOne.setName("Bill");
		tigerOne.setCity("Paris");
		animals.add(tigerOne);
		
		tigerTwo.setName("Frank");
		tigerTwo.setCity("Warsaw");
		animals.add(tigerTwo);
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

