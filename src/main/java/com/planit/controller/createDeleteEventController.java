package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
import com.planit.api.DeleteEventRequest;
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
	@PreAuthorize("hasRole('USER')")
	public EventsList getEvents(@CurrentUser UserPrincipal userPrincipal) {
		EventsList events = eventService.getEventsbyUserId(userPrincipal.getId());
//		events.setEvents(eventList);
		return events;
	}

	@Override
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> deleteEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody DeleteEventRequest deleteEventRequest) {
		System.out.println("eventUUId :: " + deleteEventRequest.getEventId());
		eventService.deleteEventbyId(deleteEventRequest.getEventId());
		
		return ResponseEntity.ok(new ApiResponse(true, "Event deleted Successfully"));
	}
}
