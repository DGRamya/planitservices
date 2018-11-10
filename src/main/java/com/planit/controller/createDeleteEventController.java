package com.planit.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.CreateDeleteEventApi;
import com.planit.model.CreateEventRequest;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;
import com.planit.service.EventService;

@RestController
public class createDeleteEventController implements CreateDeleteEventApi{
	
	@Autowired
	EventService eventService;

	@Override
	@PreAuthorize("hasRole('USER')")
	public void createEvent(@CurrentUser UserPrincipal userPrincipal, 
			@RequestBody CreateEventRequest createEventRequest) {
		//System.out.println("Prinitng the event object"+createEventRequest.toString());
		
		eventService.createEvent(userPrincipal.getId(), createEventRequest);

	}

}
