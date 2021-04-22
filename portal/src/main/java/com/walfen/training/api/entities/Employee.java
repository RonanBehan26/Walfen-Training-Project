package com.walfen.training.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //this is an annotation for mapping to link this class with the database
@Table(name = "employee")
public class Employee extends User{
//This is our Employee Class, a sub class of the User, extends being the keyword here
	

	private String company;
	private String position;
	
	@Column(name = "company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "position")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}