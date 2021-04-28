package com.walfen.training.api.dtos;

import java.time.LocalDate;

public class ManagerDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String company;
	private LocalDate birthday;
	private boolean dto;
	
	public ManagerDto() {
		this.dto = true;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public boolean isDto() {
		return dto;
	}
	public void setDto(boolean dto) {
		this.dto = dto;
	}

}
