package com.planit.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
import com.planit.entity.EventDetails;
import com.planit.model.ApiResponse;
import com.planit.model.CreateEventRequest;
import com.planit.model.EventsList;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;
import com.planit.service.EventService;

@RestController
public class createDeleteEventController implements CreateDeleteEventApi{
	
	@Autowired
	EventService eventService;

	@Override
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createEvent(@CurrentUser UserPrincipal userPrincipal, 
			@RequestBody CreateEventRequest createEventRequest) {
		System.out.println("Prinitng the event object"+createEventRequest.toString());
		
		eventService.createEvent(userPrincipal.getId(), createEventRequest);
		System.out.println("event created");
		return ResponseEntity.ok(new ApiResponse(true, "Event created Successfully"));
	}
	
	@Override
	public EventsList getEvents(@CurrentUser UserPrincipal userPrincipal) {
//		ArrayList<EventDetails> eventList = new ArrayList<>();
		
//		eventList = eventService.getEventsbyUserId(userPrincipal.getId());
		
		EventsList events = eventService.getEventsbyUserId(userPrincipal.getId());
//		events.setEvents(eventList);
		return events;
	}

	@Override
	public ResponseEntity<?> deleteEvent(UserPrincipal userPrincipal, UUID eventUUId) {
		
		eventService.deleteEventbyId(eventUUId);
		
		return ResponseEntity.ok(new ApiResponse(true, "Event deleted Successfully"));
	}

}
