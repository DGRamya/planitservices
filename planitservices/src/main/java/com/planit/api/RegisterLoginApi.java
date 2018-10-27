package com.planit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;

@RequestMapping
public interface RegisterLoginApi {
	
	@PostMapping(path = "/login", consumes = "application/json")
	public void loginUser(@RequestBody LoginDetails loginDetails);
	
	@PostMapping(path = "/register", consumes = "application/json")
	public void registerUser(@RequestBody RegisterDetails registerDetails);
}
