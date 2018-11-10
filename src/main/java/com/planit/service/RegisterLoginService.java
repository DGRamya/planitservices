package com.planit.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.planit.dao.UserDetailsRepository;
import com.planit.entity.UserDet;
import com.planit.exception.ResourceNotFoundException;
import com.planit.model.AuthProvider;
import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;
import com.planit.security.UserPrincipal;

@Service
public class RegisterLoginService implements UserDetailsService{
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public Optional<UUID> validateLogin(LoginDetails loginDetails) {
//		Optional<UserDetails> userdetails = userDetailsRepository.findAllByUseridEmailid(loginDetails.getEmail());
		Optional<UserDet> userdetails = userDetailsRepository.findAllByEmailid(loginDetails.getEmail());
		if (userdetails.isPresent()) {
			UserDet userDetails = userdetails.get();
			if (loginDetails.getPassword().equals(userDetails.getPassword())) {
				return Optional.of(userDetails.getUserid());
			}
		} else {
			System.out.println("UUID not matching");
		}
		
		return Optional.of(null);
	}
	
	public int storeUserDetails(RegisterDetails registerDetails) {
		//TO DO: check if user with same email id exists
		
		UserDet userDetails = new UserDet();
		userDetails.setUserid(UUID.randomUUID());
		userDetails.setName(registerDetails.getName());
		userDetails.setEmailid(registerDetails.getEmailId());
		userDetails.setPassword(passwordEncoder.encode(registerDetails.getPassword()));
		userDetails.setContact(registerDetails.getContact());
		userDetails.setProvider(AuthProvider.local);
		
		userDetailsRepository.save(userDetails);
		return 1;
	}
	
	public UserDetails loadUserById(UUID id) {
        UserDet user = userDetailsRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
