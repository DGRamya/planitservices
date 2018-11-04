package com.planit.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
import com.planit.model.CreateEventRequest;

@RestController
public class createDeleteEventController implements CreateDeleteEventApi{

	@Override
	public void createEvent(@RequestBody CreateEventRequest createEventRequest) {
		// TODO Auto-generated method stub
		System.out.println(createEventRequest.getEventName());
	}

}
