package com.jhl.ipaiemanager.controllers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jhl.ipaiemanager.exceptions.ResourceNotFoundException;
import com.jhl.ipaiemanager.models.Role;
import com.jhl.ipaiemanager.models.Salarie;
import com.jhl.ipaiemanager.models.Utilisateur;
import com.jhl.ipaiemanager.models.Salarie.ContratDureeType;
import com.jhl.ipaiemanager.services.RoleService;
import com.jhl.ipaiemanager.services.UserService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/users"})

public class UsersRestController {	
	
	@Autowired
    private UserService userService;	
	
	
	@GetMapping("")	
	public List<Utilisateur> getUsers(){
		return this.userService.getAllUsers();
	}
	
	
	/**
	 * Création d'un nouveau utilisateur
	 * @param user
	 * @return
	 */
	@PostMapping()
    public Utilisateur createUser(@RequestBody Utilisateur user) {
		/**
        Role role =  roleService.findByRoleRefext("");                  
        Collection<Role> roles=new ArrayList<>();
        roles.add(role);
        System.out.println(roles);
        user.setRoles(roles);
        */
		return userService.create(user);
    }
	
	/**
	 * Suppression d'un utilisateur
	 * @param id
	 * @return Utilisateur user
	 */
	@DeleteMapping(path = "/{id}")
	public Optional<Utilisateur> delete(@PathVariable("id") Long id){
		Optional<Utilisateur> userDb = this.userService.findById(id);
		if(userDb.get() == null){
			throw new ResourceNotFoundException("User non trouvé " + id);
		}
		return this.userService.delete(id);
	}
	
	
}
