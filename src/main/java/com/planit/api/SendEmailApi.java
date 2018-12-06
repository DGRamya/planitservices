package com.planit.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planit.model.EmailDetail;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

@CrossOrigin
@RestController
@RequestMapping("/invites")
public interface SendEmailApi {

	@PostMapping(path = "/sendmail")
	public ResponseEntity<?> sendEmail(@CurrentUser UserPrincipal userPrincipal, @RequestBody EmailDetail emailDetail);

}
