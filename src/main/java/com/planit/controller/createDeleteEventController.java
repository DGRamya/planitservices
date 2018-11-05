package com.planit.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
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

}
