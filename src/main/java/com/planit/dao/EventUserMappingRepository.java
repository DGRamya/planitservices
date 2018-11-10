package com.planit.dao;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.planit.entity.EventUserMapping;
import com.planit.entity.EventUserMappingId;

public interface EventUserMappingRepository extends CrudRepository<EventUserMapping , EventUserMappingId>{
	ArrayList<EventUserMapping> findAllByIdUid(UUID uid);

}
