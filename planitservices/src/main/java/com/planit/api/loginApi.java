package com.planit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
public interface loginApi {
	
	@PostMapping
	public void loginUser(@RequestParam("email") String email, @RequestParam("password") String password);
	
}
