package com.walfen.training.api.dtos;

public class EmployeeDto {


private long id;
private String firstName;
private String lastName;

private String company;
private String position;
private boolean dto;


EmployeeDto(boolean dto){
	dto = true;
}

public boolean isDto() {
	return dto;
}

public void setDto(boolean dto) {
	this.dto = dto;
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

public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}

	
}
