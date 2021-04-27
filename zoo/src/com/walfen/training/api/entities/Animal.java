package com.walfen.training.api.entities;

public abstract class Animal {
	
	private long id;
	
	abstract String getType(); 
	//I don't think this needs the keyword abstract as it is so by default
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
