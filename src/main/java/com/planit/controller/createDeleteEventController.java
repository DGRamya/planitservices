package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
import com.planit.entity.EventDetails;
import com.planit.model.ApiResponse;
import com.planit.model.CreateEventRequest;
import com.planit.model.DeleteEventRequest;
import com.planit.model.Event;
import com.planit.model.EventsList;
import com.planit.model.GetEventRequest;
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
	public EventsList deleteEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody DeleteEventRequest deleteEventRequest) {
		System.out.println("eventUUId :: " + deleteEventRequest.getEventId());
		EventsList events = eventService.deleteEventbyId(deleteEventRequest.getEventId(),userPrincipal.getId());
		
		//return ResponseEntity.ok(new ApiResponse(true, "Event deleted Successfully"));
		return events;
	}

	@Override
	public EventDetails getEventDetails(@CurrentUser UserPrincipal userPrincipal,@RequestBody GetEventRequest getEventRequest) {
		// TODO Auto-generated method stub
		System.out.println("Controller -- geteventdetails -- "+getEventRequest.getEventId());
		EventDetails event = eventService.getEventDetails(getEventRequest.getEventId());
		return event;
	}

	@Override
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> updateEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody EventDetails eventDetails) {
		eventService.updateEventDetails(eventDetails);
		return ResponseEntity.ok(new ApiResponse(true, "Event updated Successfully"));
	}
}
