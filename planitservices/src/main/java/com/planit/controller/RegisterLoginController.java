package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.RegisterLoginApi;
import com.planit.model.LoginDetails;
//import com.planit.api.RegisterLoginApi;
import com.planit.model.RegisterDetails;
import com.planit.service.RegisterLoginService;

@RestController
public class RegisterLoginController implements RegisterLoginApi{
	
	@Autowired
	RegisterLoginService registerLoginService;
	
	@Override
	public ResponseEntity<String> loginUser(@RequestBody LoginDetails loginDetails) {
//		System.out.println(loginDetails.getEmail());
		if (!registerLoginService.validateLogin(loginDetails)) {
			return new ResponseEntity<>("login", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>("login", HttpStatus.OK);
		
	}

	@Override
	public void registerUser(@RequestBody RegisterDetails registerDetails) {
//		System.out.println(registerDetails.getEmailId());
		registerLoginService.storeUserDetails(registerDetails);
	}

}
