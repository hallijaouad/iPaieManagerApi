package com.jhl.ipaiemanager.controllers;




import com.jhl.ipaiemanager.models.Utilisateur;
import com.jhl.ipaiemanager.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/users"})

public class UsersRestController {	
	
	@Autowired
    private UserService userService;
	
	/**
	 * Création d'un nouveau utilisateur
	 * @param user
	 * @return
	 */
	@PostMapping()
    public Utilisateur createUser(@RequestBody Utilisateur user) {       
		return userService.create(user);
    }
	
}
