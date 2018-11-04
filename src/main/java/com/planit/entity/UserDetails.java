package com.planit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
//	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	private String name;
	
	@Id
	private String emailid;
	
	private String password;
	
	private String contact;

	public int getId() {
		return userid;
	}

	public void setId(int id) {
		this.userid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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
