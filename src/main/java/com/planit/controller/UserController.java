package com.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planit.dao.UserDetailsRepository;
import com.planit.entity.UserDet;
import com.planit.exception.ResourceNotFoundException;
import com.planit.security.UserPrincipal;
import com.planit.service.CurrentUser;

@RestController
public class UserController {

    @Autowired
    private UserDetailsRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserDet getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
