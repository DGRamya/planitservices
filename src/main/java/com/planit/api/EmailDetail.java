package com.planit.api;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class EmailDetail {
	private JSONArray emailId;

	public JSONArray getEmailId() {
		return emailId;
	}

	public void setEmailId(JSONArray emailId) {
		this.emailId = emailId;
	}
}
