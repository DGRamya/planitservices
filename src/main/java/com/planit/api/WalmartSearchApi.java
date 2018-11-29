package com.planit.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planit.model.Item;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

@CrossOrigin
@RequestMapping("/events/myevents/shopping")
public interface WalmartSearchApi {
	
	@PostMapping(path = "/search", produces = "application/json")
	public String getEvents(@CurrentUser UserPrincipal userPrincipal, @RequestBody Item item);
}
