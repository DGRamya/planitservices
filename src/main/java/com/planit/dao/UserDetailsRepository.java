package com.planit.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.planit.entity.UserDet;
import com.planit.entity.UserKey;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDet, UUID>{
//	Optional<UserDetails> findAllByUseridEmailid(String email);
//	Optional<UserDetails> findAllByUseridUserid(UUID userid);
	Optional<UserDet> findAllByEmailid(String email);
}
