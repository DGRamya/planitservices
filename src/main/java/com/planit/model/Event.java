package com.planit.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Event {
	private UUID eventId;
	private String eventName;
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	private String venue;
	public Event(UUID eventId, String eventName, String venue) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.venue = venue;
	}
	public UUID getEventId() {
		return eventId;
	}
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
}
