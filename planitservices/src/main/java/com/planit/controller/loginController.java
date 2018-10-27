package com.planit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.planit.api.loginApi;

@Controller
public class loginController implements loginApi{

	@Override
	public void loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		
	}

}
