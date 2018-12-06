package com.planit.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EventDetails {
	@Id
	private UUID eventid;
	
	private String eventname;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventdate;
	
	private String venue;
	private String invitationMessage;
	
	@ElementCollection
	private Map<String, Boolean> invitationList;
	
	@ElementCollection
	private Map<String, Boolean> shoppingList;
	
	@OneToMany(
	        mappedBy = "event",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)

	private List<EventUserMapping> users = new ArrayList<>();
	
	public EventDetails() {
		
	}

	public EventDetails(UUID eventid, String eventname, Date eventdate, String venue, String invitationMessage,
			Map<String, Boolean> invitationList, Map<String, Boolean> shoppingList,
			Map<String, Boolean> todoList) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventdate = eventdate;
		this.venue = venue;
		this.invitationMessage = invitationMessage;
		this.invitationList = invitationList;
		this.shoppingList = shoppingList;
		
		this.todoList = todoList;
	}

	public UUID getEventid() {
		return eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public Date getEventdate() {
		return eventdate;
	}

	public String getVenue() {
		return venue;
	}

	public String getInvitationMessage() {
		return invitationMessage;
	}

	public Map<String, Boolean> getInvitationList() {
		return invitationList;
	}

	public Map<String, Boolean> getShoppingList() {
		return shoppingList;
	}

	public Map<String, Boolean> getTodoList() {
		return todoList;
	}

	@ElementCollection
	private Map<String, Boolean> todoList;
}
