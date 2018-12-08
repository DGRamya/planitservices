package com.planit.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.planit.entity.EventDetails;
import com.planit.model.CreateEventRequest;
import com.planit.model.DeleteEventRequest;
import com.planit.model.Event;
import com.planit.model.EventsList;
import com.planit.model.GetEventRequest;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;
import com.planit.model.AddOrganizer;

@CrossOrigin
@RestController
@RequestMapping("/events/myevents")
public interface CreateDeleteEventApi {
	
	@PostMapping(path = "/create", consumes = "application/json")
	public ResponseEntity<?> createEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody CreateEventRequest createEventRequest);
	
	@GetMapping(path = "/", produces = "application/json")
	public EventsList getEvents(@CurrentUser UserPrincipal userPrincipal);
	
	@PostMapping(path = "/delete")
	public EventsList deleteEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody DeleteEventRequest deleteEventRequest);

	@PostMapping(path = "/eventdetails", produces = "application/json")
	public EventDetails getEventDetails(@CurrentUser UserPrincipal userPrincipal, @RequestBody GetEventRequest getEventRequest);
	
	@PostMapping(path = "/update", produces = "application/json")
	public ResponseEntity<?> updateEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody EventDetails eventDetails);
	
	@PostMapping(path = "/addOrganizer", produces = "application/json")
	public ResponseEntity<?> addOrganizer(@CurrentUser UserPrincipal userPrincipal, @RequestBody AddOrganizer addOrganizer );
	
}
