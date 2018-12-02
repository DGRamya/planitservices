package com.planit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.planit.entity.EventUserMapping;
import com.planit.entity.EventUserMappingId;
import com.planit.entity.UserDet;
import com.planit.entity.UserKey;

public interface EventUserMappingRepository extends CrudRepository<EventUserMapping , EventUserMappingId>{
	ArrayList<EventUserMapping> findAllByIdUid(UUID uid);

}
