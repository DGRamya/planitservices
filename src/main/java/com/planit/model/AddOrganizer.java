package com.planit.model;
import java.util.List;
import java.util.UUID;
import org.json.simple.JSONArray;

public class AddOrganizer {
	


	private JSONArray emailId;
	private UUID eventId;


	public UUID getEventId() {
		return eventId;
	}
	public JSONArray getEmailId() {
		return emailId;
	}
	public void setEmailId(JSONArray emailId) {
		this.emailId = emailId;
	}
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}



}
