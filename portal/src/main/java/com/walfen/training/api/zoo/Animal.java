package com.walfen.training.api.zoo;

public abstract class Animal extends Zoo {
	
	private long id;
	
	public abstract String getType(); 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
