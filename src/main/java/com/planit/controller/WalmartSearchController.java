package com.planit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.planit.api.WalmartSearchApi;
import com.planit.model.Item;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

@RestController
public class WalmartSearchController implements WalmartSearchApi{

	@Override
	@PreAuthorize("hasRole('USER')")
	public String getEvents(@CurrentUser UserPrincipal userPrincipal, @RequestBody Item item) {
		System.out.println(item.getItem());
		final String uri = "http://api.walmartlabs.com/v1/search?apiKey=4tz6q3hqa6xdnn6j7u6cgq8t&query="+item.getItem();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		return result;
	}
	
}
