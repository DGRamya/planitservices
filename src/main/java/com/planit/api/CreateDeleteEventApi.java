package com.planit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planit.model.CreateEventRequest;

@RestController
@RequestMapping("/events/myevents")
public interface CreateDeleteEventApi {
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void createEvent(@RequestBody CreateEventRequest createEventRequest);
}
