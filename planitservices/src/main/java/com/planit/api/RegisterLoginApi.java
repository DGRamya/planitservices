package com.planit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.planit.model.RegisterDetails;

@RequestMapping
public interface RegisterLoginApi {
	
	@PostMapping("/login")
	public void loginUser(@RequestParam("email") String email, @RequestParam("password") String password);
	
	@PostMapping(path = "/register", consumes = "application/json")
	public void registerUser(@RequestBody RegisterDetails registerDetails);
}
