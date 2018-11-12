package com.planit.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.planit.api.CreateDeleteEventApi;
import com.planit.entity.EventDetails;
import com.planit.model.CreateEventRequest;
import com.planit.service.EventService;

@RestController
public class createDeleteEventController implements CreateDeleteEventApi{
	
	@Autowired
	EventService eventService;

	@Override
	public void createEvent(@RequestParam("userid") UUID userUUId, 
			@RequestBody CreateEventRequest createEventRequest) {
		//System.out.println("Prinitng the event object"+createEventRequest.toString());
		
		eventService.createEvent(userUUId, createEventRequest);

	}
	
	public void deleteEvent(@RequestParam("eventid") UUID eventUUId) {
		System.out.println("in delete event!!"+eventUUId);
		eventService.deleteEvent(eventUUId);
	}
	
	public JsonArray getEvents(@RequestParam("userid") UUID userUUId) {
		ArrayList<EventDetails> eventList = new ArrayList<>();
		JsonObject jsonObject;
		JsonArray eventJsonArray = new JsonArray();
		
		eventList = eventService.getEventsbyUserId(userUUId);
		
		for (EventDetails event : eventList) {
			jsonObject = new JsonObject();
			jsonObject.addProperty("eventid", event.getEventid().toString());
			jsonObject.addProperty("eventname", event.getEventname());
			jsonObject.addProperty("venue", event.getVenue());
			eventJsonArray.add(jsonObject);
		}
		System.out.println("ja -- "+eventJsonArray.toString());
		
		return eventJsonArray;
	}

}
