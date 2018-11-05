package com.planit.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	private List<String> invitationList;
	
	@ElementCollection
	private List<String> shoppingList;
	
	@OneToMany(
	        mappedBy = "event",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)

	private List<EventUserMapping> users = new ArrayList<>();
	
	public EventDetails() {
		
	}

	public EventDetails(UUID eventid, String eventname, Date eventdate, String venue, String invitationMessage,
			List<String> invitationList, List<String> shoppingList,
			List<String> todoList) {
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

	public List<String> getInvitationList() {
		return invitationList;
	}

	public List<String> getShoppingList() {
		return shoppingList;
	}

	public List<String> getTodoList() {
		return todoList;
	}

	@ElementCollection
	private List<String> todoList;
}
