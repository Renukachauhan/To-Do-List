package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register implements Serializable{

	private static final long serialVersionUID = -3076687306855893696L;//TO RUN IT ON OTHER SYSTEMS AS WELL 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//TO GET THE VALUES FORM 1
	
	private int id;
	private String username;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	//to check the values are working or not
	@Override
	public String toString() {
		return "Register [id=" + id + ", username=" + username + "]";
	}
	

	
	
}
