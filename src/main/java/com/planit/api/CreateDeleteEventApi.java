package com.planit.api;

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
import com.planit.model.CreateEventRequest;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

@CrossOrigin
@RestController
@RequestMapping("/events/myevents")
public interface CreateDeleteEventApi {
	
	@PostMapping(path = "/create", consumes = "application/json")
	public ResponseEntity<?> createEvent(@CurrentUser UserPrincipal userPrincipal, @RequestBody CreateEventRequest createEventRequest);
	
	@PostMapping(path = "/", consumes = "application/json")
	public ResponseEntity<?> getEvents(@CurrentUser UserPrincipal userPrincipal);
	
}
