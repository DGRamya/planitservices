package com.planit.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;

@Entity
public class UserDetails {
	
	@EmbeddedId
	private UserKey userid;
	
	private String name;
	
	private String password;
	
	private String contact;

	public UserKey getUserid() {
		return userid;
	}

	public void setUserid(UserKey userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
