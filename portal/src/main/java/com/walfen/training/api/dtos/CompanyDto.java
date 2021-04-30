package com.walfen.training.api.dtos;

public class CompanyDto {
	
	private Long id;
	private String name;
	private String city;
	private boolean dto;


	public CompanyDto(){
		this.dto = true;
	}


	public boolean isDto() {
		return dto;
	}


	public void setDto(boolean dto) {
		this.dto = dto;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


