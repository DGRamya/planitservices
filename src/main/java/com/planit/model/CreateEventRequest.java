package com.planit.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CreateEventRequest {
	@Override
	public String toString() {
		return "CreateEventRequest [eventName=" + eventName + ", eventDate=" + eventDate + ", venue=" + venue
				+ ", invitationMessage=" + invitationMessage + ", shoppingList=" + shoppingList + ", invitationList="
				+ invitationList + ", todoList=" + todoList + "]";
	}
	private String eventName;
	private Date eventDate;
	private String venue;
	private String invitationMessage;
	private Map<String, Boolean> shoppingList;
	private Map<String, Boolean> invitationList;
	private Map<String, Boolean> todoList;
	public String getEventName() {
		return eventName;
	}
	public Map<String, Boolean> getShoppingList() {
		return shoppingList;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public String getVenue() {
		return venue;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public Map<String, Boolean> getInvitationList() {
		return invitationList;
	}
	public Map<String, Boolean> getTodoList() {
		return todoList;
	}
}
