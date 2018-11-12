package com.planit.model;

import java.util.ArrayList;
import java.util.List;

public class EventsList {
	private List<Event> events;
	
	public EventsList() {
		events = new ArrayList<>();
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
