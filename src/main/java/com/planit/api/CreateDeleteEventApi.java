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
import com.planit.model.EventsList;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

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
	
}
