package com.jhl.ipaiemanager.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.jhl.ipaiemanager.models.Utilisateur;

import com.jhl.ipaiemanager.dao.UtiliseteurRepository;
import com.jhl.ipaiemanager.exceptions.ResourceNotFoundException;

import javax.transaction.Transactional;
import javax.validation.Validator;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UtiliseteurRepository userRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserServiceImpl(UtiliseteurRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    		this.userRepository = userRepository;
    		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    public Utilisateur getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	@Override
	public List<Utilisateur> getAllUsers() {
		List<Utilisateur> users = this.userRepository.findAll();   
        return users;		
	}	
	

	@Override
	public List<Utilisateur> findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur create(Utilisateur user) {
		/**
        Role role =  roleService.findByRoleRefext("");                  
        Collection<Role> roles=new ArrayList<>();
        roles.add(role);
        System.out.println(Utilisateur);
        user.setRoles(roles);
        */
		
		//Validator validator = getValidator();
	    //validator.validate(user).stream().forEach(ValidatedValueExample::printError);
		
		//verifier est ce que l'utilisateur existe déja sur bdd
		Utilisateur userBddData = this.getUserByEmail(user.getEmail());		
		if(userBddData != null){
			throw new ResourceNotFoundException(Utilisateur.RESOURCE_PATH, String.format("Email %s existe déja pour un autre utilisateur", user.getEmail()));
		}	
		
		// si attribut actif pas dans le flux
		if(user.getActif() == null) {
			user.setActif(0);
		}
		
		// check paword and confirmation
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}

	@Override
	public Utilisateur update(Utilisateur user) {
		return userRepository.save(user);		
	}

	@Override
	public Optional<Utilisateur> delete(Long id) {
		this.userRepository.deleteById(id);
		return null;
	}

	@Override
	public Utilisateur getUserById(Long id) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur %d n'est pas trouvé", id));
	}
    
}
