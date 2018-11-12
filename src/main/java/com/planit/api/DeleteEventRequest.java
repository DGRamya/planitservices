package com.planit.api;

import java.util.UUID;

public class DeleteEventRequest {
	private UUID eventId;

	public UUID getEventId() {
		return eventId;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}

}
