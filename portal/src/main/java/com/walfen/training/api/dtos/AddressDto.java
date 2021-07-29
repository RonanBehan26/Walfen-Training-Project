package com.walfen.training.api.dtos;

public class AddressDto {

	private long id;
	private String street;
	private String city;
	private String country;
	private boolean dto;
	
	public AddressDto(){
		this.dto = true;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean isDto() {
		return dto;
	}

	public void setDto(boolean dto) {
		this.dto = dto;
	}	

}
