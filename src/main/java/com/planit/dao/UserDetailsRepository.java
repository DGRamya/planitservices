package com.planit.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.planit.entity.UserDetails;
import com.planit.entity.UserKey;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, UserKey>{
	Optional<UserDetails> findAllByUseridEmailid(String email);
}
