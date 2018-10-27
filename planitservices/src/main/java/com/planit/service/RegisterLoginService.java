package com.planit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planit.dao.UserDetailsRepository;
import com.planit.entity.UserDetails;

@Service
public class RegisterLoginService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public int validateLogin(String email, String password) {
		UserDetails userdetails = userDetailsRepository.findById(email).get();
		if (userdetails == null) {
			
		}
		if (password.equals(userdetails.getPassword())) {
			return 1;
		}
		return -1;
	}

}
