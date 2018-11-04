package com.planit.dao;


import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.planit.entity.EventDetails;


public interface EventDetailsRepository extends CrudRepository<EventDetails, UUID>{


}
