package com.planit.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planit.dao.EventDetailsRepository;
import com.planit.dao.EventUserMappingRepository;
import com.planit.dao.UserDetailsRepository;
import com.planit.entity.EventDetails;
import com.planit.entity.EventUserMapping;
import com.planit.entity.UserDet;
import com.planit.model.CreateEventRequest;
import com.planit.model.Event;
import com.planit.model.EventsList;

@Service
public class EventService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	EventDetailsRepository eventDetailsRepository;
	
	@Autowired
	EventUserMappingRepository eventUserMappingRepository;
	
	public void createEvent(UUID userid, CreateEventRequest createEventRequest) {
		EventDetails eventDetails = new EventDetails(UUID.randomUUID(), createEventRequest.getEventName(), createEventRequest.getEventDate(), createEventRequest.getVenue(), createEventRequest.getInvitationMessage(),createEventRequest.getInvitationList(), createEventRequest.getShoppingList(), createEventRequest.getTodoList());
		UserDet userdetails = getUserDetails(userid);
		EventUserMapping eventUserMapping = new EventUserMapping(eventDetails,userdetails);
		eventDetailsRepository.save(eventDetails);
		eventUserMappingRepository.save(eventUserMapping);
	}
	
	private UserDet getUserDetails(UUID userid) throws NoSuchElementException {
		Optional<UserDet> userdetails = userDetailsRepository.findById(userid);
		
		return userdetails.orElseThrow(
				()-> new NoSuchElementException("UserId not found")
		);
	}
	
	public EventsList deleteEventbyId(UUID eventid,UUID userUUId) {
		EventsList events = new EventsList();
		System.out.println("In deleteEvent -- EventService = "+eventid);
		eventDetailsRepository.deleteById(eventid);
		events = getEventsbyUserId(userUUId);
		
		return events;
	}
	
	public EventDetails getEventDetails(UUID eventid) {
		System.out.println("EventService --- getEventDetails :: "+eventid.toString());
		Optional<EventDetails> eventDetails = eventDetailsRepository.findById(eventid);
		return eventDetails.orElseThrow(
				()-> new NoSuchElementException("EventId not found")
		);
	}
	
	public EventsList getEventsbyUserId(UUID userUUId) {
		ArrayList<EventDetails> eventList = new ArrayList<>();
		ArrayList<UUID> eventIdList = new ArrayList<>();
		ArrayList<EventUserMapping> eventUserList = new ArrayList<>();
		
		eventUserList = eventUserMappingRepository.findAllByIdUid(userUUId);
		
		
		if(eventUserList.size() > 0) {
			for (EventUserMapping eventUser : eventUserList) {
				eventIdList.add(eventUser.getEvent().getEventid());
			}
			eventList = (ArrayList<EventDetails>) eventDetailsRepository.findAllById(eventIdList);
		}
		EventsList events = new EventsList();
		for (EventDetails event : eventList) {
			System.out.println(event.getEventname());
			events.addEvent(new Event(event.getEventid(), event.getEventname(), event.getVenue()));
		}
		
		return events;
	}
	
	public boolean updateEventDetails(EventDetails eventDetails) {
		eventDetailsRepository.save(eventDetails);
		return true;
	}
	
	
}
