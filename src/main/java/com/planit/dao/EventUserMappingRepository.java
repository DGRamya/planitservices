package com.planit.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.planit.entity.EventUserMapping;
import com.planit.entity.EventUserMappingId;
import com.planit.entity.UserDetails;
import com.planit.entity.UserKey;

public interface EventUserMappingRepository extends CrudRepository<EventUserMapping , EventUserMappingId>{

}
