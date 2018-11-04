package com.planit.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class EventUserMappingId implements Serializable{
	private UUID uid;
	
	private UUID eid;
	
	private EventUserMappingId() {}
	 
    public EventUserMappingId(
       UUID uid,
       UUID eid) {
        this.uid = uid;
        this.eid = eid;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        EventUserMappingId that = (EventUserMappingId) o;
        return Objects.equals(uid, that.uid) && 
               Objects.equals(eid, that.eid);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(uid, eid);
    }
	
}
