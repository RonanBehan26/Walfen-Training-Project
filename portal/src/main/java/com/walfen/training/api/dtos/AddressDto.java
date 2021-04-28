package com.walfen.training.api.dtos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="address")
public class AddressDto {

	
	private long id;
	private String street;
	private String city;
	private String country;
	private boolean addressDto;
	
	public boolean isAddressDto() {
		return addressDto;
	}
	
	AddressDto(boolean addressDto){
		addressDto = true;
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

	public void setAddressDto(boolean addressDto) {
		this.addressDto = addressDto;
	}	

	
}
