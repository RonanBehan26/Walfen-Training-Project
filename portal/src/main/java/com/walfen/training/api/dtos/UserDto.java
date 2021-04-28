package com.walfen.training.api.dtos;

public class UserDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private boolean dto;
	
	public UserDto(boolean dto) {
		dto = true;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isDto() {
		return dto;
	}
	public void setDto(boolean dto) {
		this.dto = dto;
	}
	
}
