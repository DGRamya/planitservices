package com.planit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.planit.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, String>{
	
}
