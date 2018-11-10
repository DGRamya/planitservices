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
import com.planit.entity.UserDetails;
import com.planit.model.CreateEventRequest;

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
		UserDetails userdetails = getUserDetails(userid);
		EventUserMapping eventUserMapping = new EventUserMapping(eventDetails,userdetails);
		eventDetailsRepository.save(eventDetails);
		eventUserMappingRepository.save(eventUserMapping);
		
		
	}
	
	private UserDetails getUserDetails(UUID userid) throws NoSuchElementException {
		Optional<UserDetails> userdetails = userDetailsRepository.findById(userid);
		
		return userdetails.orElseThrow(
				()-> new NoSuchElementException("UserId not found")
				);
	}
	
	public void deleteEvent(UUID eventid) {
		System.out.println("In deleteEvent -- EventService = "+eventid);
		eventDetailsRepository.deleteById(eventid);
	}
	
	public ArrayList<EventDetails> getEventsbyUserId(UUID userUUId) {
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
		
		return eventList;
	}
	
	
}
