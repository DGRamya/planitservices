package com.planit.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planit.model.LoginDetails;
import com.planit.model.RegisterDetails;
import com.planit.service.RegisterLoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterLoginController.class)
public class RegisterLoginControllerTest {
	
	@MockBean
	RegisterLoginService registerLoginService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	private LoginDetails loginDetails1;
	private LoginDetails loginDetails2;
	private RegisterDetails registerDetails;
	
	@Before
	public void setup() {
		loginDetails1 = new LoginDetails();
		loginDetails1.setEmail("a@iu.edu");
		loginDetails1.setPassword("xyz");
		
		loginDetails2 = new LoginDetails();
		loginDetails2.setEmail("abc@iu.edu");
		loginDetails2.setPassword("xyz");
		
		registerDetails = new RegisterDetails();
		registerDetails.setName("TestUser");
		registerDetails.setEmailId("test@test.edu");
		registerDetails.setPassword("Test");
		registerDetails.setContact("9999999999");
	}
	
	@Test
	public void shouldLogin_validUser() throws Exception{
		when(registerLoginService.validateLogin(any())).thenReturn(true);
		//String json = mapper.writeValueAsString(loginDetails1);
		mockMvc.perform(
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(loginDetails1))
				).andExpect(status().isOk());
		
	}
	@Test
	public void shouldLogin_invalidUser() throws Exception{
		when(registerLoginService.validateLogin(loginDetails2)).thenReturn(false);
		String json = mapper.writeValueAsString(loginDetails2);
		mockMvc.perform(
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				).andExpect(status().isForbidden());
		
	}
	
	@Test 
	public void shouldRegister_newUser() throws Exception{
		when(registerLoginService.storeUserDetails(registerDetails)).thenReturn(1);
		mockMvc.perform(
				post("/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(registerDetails))
				).andExpect(status().isOk());
	}

}
