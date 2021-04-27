package com.walfen.training.api.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="manager")
public class Manager {

private long id;

private String firstName;

private String lastName;

private String company;

private LocalDate birthday;


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

@Column(name = "first_name")
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

@Column(name = "last_name")
public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Column(name = "company")
public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

@Column(name = "birthday")
public LocalDate getBirthday() {
	return birthday;
}

public void setBirthday(LocalDate birthday) {
	this.birthday = birthday;
}


}