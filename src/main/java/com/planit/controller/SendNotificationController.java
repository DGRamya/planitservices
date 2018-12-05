package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planit.api.EmailDetail;
import com.planit.api.SendEmailApi;
import com.planit.model.ApiResponse;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;
import com.planit.service.SendNotificationService;

@RestController
public class SendNotificationController implements SendEmailApi{
	
	@Autowired
	private SendNotificationService sendNotificationService;

	@Autowired
	private EmailDetail emailDetail;
	
	@Override
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> sendEmail(@CurrentUser UserPrincipal userPrincipal, @RequestBody EmailDetail emailDetail) {
		System.out.println("finally spring sending email... ");
		try {
			sendNotificationService.sendEmail(emailDetail);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return ResponseEntity.ok(new ApiResponse(true, "Email Sent Successfully"));
	}	
}
