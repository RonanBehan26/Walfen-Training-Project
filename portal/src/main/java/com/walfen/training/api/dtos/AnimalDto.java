package com.walfen.training.api.dtos;

public abstract class AnimalDto {
	
	private long id;
	
	public abstract String getType(); 
	
	public AnimalDto() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
