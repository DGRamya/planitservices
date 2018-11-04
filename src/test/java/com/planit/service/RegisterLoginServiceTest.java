//package com.planit.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.planit.dao.UserDetailsRepository;
//import com.planit.entity.UserDetails;
//import com.planit.entity.UserKey;
//import com.planit.model.LoginDetails;
//import com.planit.model.RegisterDetails;
//
//@RunWith(SpringRunner.class)
//public class RegisterLoginServiceTest {
//	
//	@Mock 
//	UserDetailsRepository userDetailsRepository;
//	
//	@InjectMocks
//	RegisterLoginService registerLoginService;
//	
//	private LoginDetails loginDetails1;
//	private RegisterDetails registerDetails;
//	private UserDetails userDetails;
//	@Before
//	public void setup() {
//
//		loginDetails1 = new LoginDetails();
//		loginDetails1.setEmail("a@iu.edu");
//		loginDetails1.setPassword("xyz");
//		
//		userDetails = new UserDetails();
//		userDetails.setName("TestUser");
//		userDetails.setUserid(UUID.randomUUID());
//		userDetails.setEmailid("a@iu.edu");
//		userDetails.setPassword("xyz");
//		userDetails.setContact("9999999999");
//		
//		registerDetails = new RegisterDetails();
//		registerDetails.setName("TestUser");
//		registerDetails.setEmailId("test@test.edu");
//		registerDetails.setPassword("Test");
//		registerDetails.setContact("9999999999");
//	}
//	
//	@Test
//	public void validateLogin() {
//		Mockito.when(userDetailsRepository.findAllByUseridEmailid("a@iu.edu")).thenReturn(Optional.of(userDetails));
//		boolean response = registerLoginService.validateLogin(loginDetails1);
//		assertEquals(response, true);
//	}
//	@Test
//	public void validateLogin_invalidUser() {
//		userDetails.setPassword("atest");
//		Mockito.when(userDetailsRepository.findAllByUseridEmailid("a@iu.edu")).thenReturn(Optional.of(userDetails));
//		boolean response = registerLoginService.validateLogin(loginDetails1);
//		assertNotEquals(response, true);
//	}
//	@Test
//	public void storeUserDetails() {
//		
//	}
//
//}
