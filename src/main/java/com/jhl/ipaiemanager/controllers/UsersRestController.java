package com.jhl.ipaiemanager.controllers;

import com.jhl.ipaiemanager.exceptions.ConflictException;


import com.jhl.ipaiemanager.models.Utilisateur;

import com.jhl.ipaiemanager.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
@RequestMapping({Utilisateur.RESOURCE_PATH})
@Api(tags = "utilisateurs")

public class UsersRestController {	
	
	@Autowired
    private UserService userService;	
	
	/**
	 * Récupération de tous les utilisateurs
	 * @return
	 */
	
	@GetMapping("")	
	@ApiOperation(value = "Utilisateurs")
	
	public List<Utilisateur> getUsers(){
		return this.userService.getAllUsers();
	}
	
	
	/**
	 * Récupération des informations d'un utilisateur
	 * @param id
	 * @return
	 */
	
	@GetMapping("{id}")	
	public Utilisateur getUser(@PathVariable(value = "id") Long id) {
		// TODO Auto-generated method stub
		return this.userService.getUserById(id);
	}	
	
	
	/**
	 * Création d'un nouveau utilisateur
	 * @param user
	 * @return
	 */
	@PostMapping("")
    public Utilisateur createUser(@Valid @RequestBody Utilisateur user){
		return userService.create(user);
    }
	
	/**
	 * Mettre à jour un utilisateur existant avec une nouvelle représentation. L'état entier de l'entité est
	 * remplacé par celui fourni avec RequestBody (cela signifie que les champs 
	 * nuls sont exclus de la maj de l'entité utilisateur)
	 * @param id
	 * @param user
	 * @return user modifier
	 */
	@PutMapping(path = "{id}")
    public Utilisateur updateUser(@PathVariable(value = "id") final Long id, @RequestBody  Utilisateur userNewData) {
		/**
        Role role =  roleService.findByRoleRefext("");                  
        Collection<Role> roles=new ArrayList<>();
        roles.add(role);
        System.out.println(Utilisateur);
        user.setRoles(roles);
        */
		// Donnée de l'utilisateur sur BDD
		Utilisateur userBddData = this.userService.getUserById(id);	
		//Controle sur update email
		//Si email à modifier de la bdd # de l'email du flux
		if(!userBddData.getEmail().equals(userNewData.getEmail())){
			/* si le noouvau email existe déja dans la bdd
			try{
				Utilisateur userBddDataByEamail = userService.getUserByEmail(userNewData.getEmail());
				if(userBddDataByEamail.getId() != null){
					throw new ConflictException(Utilisateur.RESOURCE_PATH, String.format("Email %s existe déja pour un autre utilisateur", userNewData.getEmail()));
				}
			}catch(Exception ex){
				throw new ResourceNotFoundException(Utilisateur.RESOURCE_PATH, String.format("Error", userNewData.getEmail()), ex);
			}	*/	
			throw new ConflictException(Utilisateur.RESOURCE_PATH, String.format("Traitement en cours pour la modification de l'email", userNewData.getEmail()));
			
		}		
		// Copier les données envoyer par PUT vers données de la bdd
		BeanUtils.copyProperties(userNewData, userBddData, "id", "password");	
		//force update user new data
		return this.userService.update(userBddData);
    }
	
	/**
	 * Suppression d'un utilisateur
	 * @param id
	 * @return Utilisateur user
	 */
	@DeleteMapping(path = "/{id}")
	public Optional<Utilisateur> delete(@PathVariable("id") Long id){
		Utilisateur userDb = this.userService.getUserById(id);		
		return this.userService.delete(userDb.getId());
	}
	
	
	
	
}
