package com.planit.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class EventUserMapping {
	@EmbeddedId
    private EventUserMappingId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eid")
    private EventDetails event;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("uid")
    private UserDetails user;
 
 
    private EventUserMapping() {}


	public EventUserMapping(EventDetails event, UserDetails user) {
		this.event = event;
		this.user = user;
		this.id = new EventUserMappingId(user.getUserid(), event.getEventid());
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        EventUserMapping that = (EventUserMapping) o;
        return Objects.equals(event, that.event) &&
               Objects.equals(user, that.user);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(event, user);
    }

	public EventUserMappingId getId() {
		return id;
	}


	public void setId(EventUserMappingId id) {
		this.id = id;
	}


	public EventDetails getEvent() {
		return event;
	}


	public void setEvent(EventDetails event) {
		this.event = event;
	}


	public UserDetails getUser() {
		return user;
	}


	public void setUser(UserDetails user) {
		this.user = user;
	}
 
   
}
