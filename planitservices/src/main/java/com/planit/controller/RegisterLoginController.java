package com.planit.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.RegisterLoginApi;
import com.planit.model.LoginDetails;
//import com.planit.api.RegisterLoginApi;
import com.planit.model.RegisterDetails;

@RestController
//@RequestMapping("/hi")
public class RegisterLoginController implements RegisterLoginApi{

	@Override
	public void loginUser(@RequestBody LoginDetails loginDetails) {
		System.out.println(loginDetails.getEmail());
	}

	@Override
	public void registerUser(@RequestBody RegisterDetails registerDetails) {
		// TODO Auto-generated method stub
		System.out.println(registerDetails.getEmailId());
	}
	
//	@RequestMapping("/hi")
//	@GetMapping("/")
//	public String welcome() {
//		System.out.println("welcome");
//		return "welcome";
//	}
	

}
