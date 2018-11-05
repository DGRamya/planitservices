package com.planit.api;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;


@CrossOrigin
@RequestMapping
public interface RegisterLoginApi {
	
	@PostMapping(path = "/login", consumes = "application/json")
	public ResponseEntity<UUID> loginUser(@RequestBody LoginDetails loginDetails);
	
	@PostMapping(path = "/register", consumes = "application/json")
	public void registerUser(@RequestBody RegisterDetails registerDetails);
}
