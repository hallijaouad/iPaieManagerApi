package com.ischool.controllers;
import java.util.List;


import javax.validation.Valid;

import com.ischool.models.User;
import com.ischool.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/users"})

public class UsersRestController {	
	
	@Autowired
    private UserService userService;
	
	// Get method pour recupérer la liste des éleves
	
	@GetMapping
	public List<User> getEleves(){
		return userService.findAll();		
	}
	
	/**
	 * Get method with id for show detail student
	 * @param id
	 * @return
	 */
	@GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") Long id){
        return userService.findById(id);
    }
	
	/**
	 * Save new user
	 * @param user
	 * @return
	 */
	@PostMapping
    public User create(@RequestBody User user){			
        return userService.create(user);
    }
	
	
	@PutMapping("/users/{id}")
    public User update(@PathVariable(value = "id") Long id, @Valid @RequestBody User user){
		User user1 = userService.findById(id);
		user1.setNom(user.getNom());
		user1.setPrenom(user.getPrenom());
        return userService.update(user1);
    }
	
	
	
	@GetMapping(path = {"/filtre/{nom}"})
    public List<User> getUsers(@PathVariable(name = "nom", value = "nom") String nom){
		if(nom != "") {
			return userService.findByNom(nom);
		}else {
			return this.getEleves();
		}
        
    }
	
	@DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
	
}
