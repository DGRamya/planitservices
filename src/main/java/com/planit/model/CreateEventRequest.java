package com.planit.model;

import java.util.Date;
import java.util.List;

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
	private List<String> shoppingList;
	private List<String> invitationList;
	private List<String> todoList;
	public String getEventName() {
		return eventName;
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
	public List<String> getShoppingList() {
		return shoppingList;
	}
	public List<String> getInvitationList() {
		return invitationList;
	}
	public List<String> getTodoList() {
		return todoList;
	}
}
