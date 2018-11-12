package com.planit.api;

import java.util.UUID;

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

@CrossOrigin
@RestController
@RequestMapping("/events/myevents")
public interface CreateDeleteEventApi {
	
	@PostMapping(path = "/create", consumes = "application/json")
	public void createEvent(@RequestParam("userid") UUID userUUId, @RequestBody CreateEventRequest createEventRequest);
	
	//@PostMapping(path = "/", consumes = "application/json")
	//@GetMapping(path = "/")
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonArray getEvents(@RequestParam("userid") UUID userUUId);
}
