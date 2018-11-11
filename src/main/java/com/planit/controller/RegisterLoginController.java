package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.RegisterLoginApi;
import com.planit.dao.UserDetailsRepository;
import com.planit.model.ApiResponse;
import com.planit.model.AuthResponse;
import com.planit.model.LoginDetails;
//import com.planit.api.RegisterLoginApi;
import com.planit.model.RegisterDetails;
import com.planit.security.TokenProvider;
import com.planit.service.RegisterLoginService;


@RestController
public class RegisterLoginController implements RegisterLoginApi{
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsRepository userRepository;

    @Autowired
    private TokenProvider tokenProvider;
	
	@Autowired
	RegisterLoginService registerLoginService;
	
	@Override
	public ResponseEntity<?> loginUser(@RequestBody LoginDetails loginDetails) {
//		System.out.println(loginDetails.getEmail());
//		Optional<UUID> userid = registerLoginService.validateLogin(loginDetails);
//		if (userid.isPresent()) {
//			return new ResponseEntity<>(userid.get(), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginDetails.getEmail(),
						loginDetails.getPassword()
						)
				);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		System.out.println("printing token "+token);
		return ResponseEntity.ok(new AuthResponse(token));

	}

	@Override
	public ResponseEntity<?> registerUser(@RequestBody RegisterDetails registerDetails) {
//		System.out.println(registerDetails.getEmailId());
		registerLoginService.storeUserDetails(registerDetails);
		return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
	}

}
