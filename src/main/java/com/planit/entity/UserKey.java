package com.planit.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class UserKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5708995458292449887L;
	private UUID userid;
	private String emailid;
	
	public UUID getUserid() {
		return userid;
	}
	public void setUserid(UUID uuid) {
		this.userid = uuid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserKey)) return false;
        UserKey that = (UserKey) o;
        return Objects.equals(getEmailid(), that.getEmailid());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getUserid(), getEmailid());
    }
}
