package com.planit.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planit.dao.UserDetailsRepository;
import com.planit.entity.UserDetails;
import com.planit.entity.UserKey;
import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;

@Service
public class RegisterLoginService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public boolean validateLogin(LoginDetails loginDetails) {
		UserKey userKey = new UserKey();
		userKey.setUserid(UUID.randomUUID());
		userKey.setEmailid(loginDetails.getEmail());
//		Optional<UserDetails> userdetails = userDetailsRepository.findById(userKey);
		Optional<UserDetails> userdetails = userDetailsRepository.findAllByUseridEmailid(loginDetails.getEmail());
		if (userdetails.isPresent()) {
			if (loginDetails.getPassword().equals(userdetails.get().getPassword())) {
				return true;
			}
		} else {
			System.out.println("UUID not matching");
		}
		
		return false;
	}
	
	public int storeUserDetails(RegisterDetails registerDetails) {
		//TO DO: check if user with same email id exists
		UserKey userKey = new UserKey();
		userKey.setUserid(UUID.randomUUID());
		userKey.setEmailid(registerDetails.getEmailId());
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName(registerDetails.getName());
		userDetails.setUserid(userKey);
		userDetails.setPassword(registerDetails.getPassword());
		userDetails.setContact(registerDetails.getContact());
		
		userDetailsRepository.save(userDetails);
		return 1;
	}

}
