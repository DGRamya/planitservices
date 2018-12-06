package com.planit.model;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class EmailDetail {
	private JSONArray emailId;
	private String emailContent = "You are invited";
	private String emailSubject = "You are invited";

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public JSONArray getEmailId() {
		return emailId;
	}

	public void setEmailId(JSONArray emailId) {
		this.emailId = emailId;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
}
