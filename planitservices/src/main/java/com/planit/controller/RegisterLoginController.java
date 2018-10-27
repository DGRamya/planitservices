package com.planit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.planit.api.RegisterLoginApi;
import com.planit.model.RegisterDetails;

@Controller
public class RegisterLoginController implements RegisterLoginApi{

	@Override
	public void loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		
	}

	@Override
	public void registerUser(@RequestBody RegisterDetails registerDetails) {
		// TODO Auto-generated method stub
		System.out.println(registerDetails.getEmailId());
	}

}
