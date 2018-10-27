package com.planit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planit.dao.UserDetailsRepository;
import com.planit.entity.UserDetails;
import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;

@Service
public class RegisterLoginService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public int validateLogin(LoginDetails loginDetails) {
		UserDetails userdetails = userDetailsRepository.findById(loginDetails.getEmail()).get();
		if (userdetails == null) {
			
		}
		if (loginDetails.getPassword().equals(userdetails.getPassword())) {
			return 1;
		}
		return -1;
	}
	
	public void storeUserDetails(RegisterDetails registerDetails) {
		UserDetails userDetails = new UserDetails();
		userDetails.setName(registerDetails.getName());
		userDetails.setEmailid(registerDetails.getEmailId());
		userDetails.setPassword(registerDetails.getPassword());
		userDetails.setContact(registerDetails.getContact());
		
		userDetailsRepository.save(userDetails);
	}

}
