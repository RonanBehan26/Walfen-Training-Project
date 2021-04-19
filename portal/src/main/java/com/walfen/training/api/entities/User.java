package com.walfen.training.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This class represents our users

@Entity
@Table(name ="user")
public class User {
	
	private long id;
	private String first_name;
	private String last_name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "first_name")
	public String getfName() {
		return first_name;
	}
	public void setfName(String first_name) {
		this.first_name = first_name;
	}
	@Column(name = "last_name")
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

}
