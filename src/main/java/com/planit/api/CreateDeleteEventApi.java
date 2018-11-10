package com.planit.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planit.model.CreateEventRequest;

@CrossOrigin
@RestController
@RequestMapping("/events/myevents")
public interface CreateDeleteEventApi {
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void createEvent(@RequestParam("userid") UUID userUUId, @RequestBody CreateEventRequest createEventRequest);
	
	@PostMapping(path = "/", consumes = "application/json")
	public void getEvents(@RequestParam("userid") UUID userUUId);
}
