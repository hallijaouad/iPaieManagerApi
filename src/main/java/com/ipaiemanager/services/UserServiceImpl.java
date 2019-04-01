package com.ipaiemanager.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipaiemanager.models.User;
import com.ipaiemanager.dao.UserRepository;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creation d'un nouveau user
     */
    
    @Override
    @Transactional
    public User create(User user) { 
        return userRepository.save(user);
    }
    
    @Override
    @Transactional
    public User update(User user) {     
        return userRepository.save(user);
    }
    
    @Override
    public List<User> findAll() {
    	return userRepository.findAll();
    }
   
    /**
     * Recherche d'un utilisateur par nom
     */
    
    @Override
    public List<User> findByNom(String nom) {
    	return userRepository.findByNom(nom);    	
    }
    
    @Override
    public User findById(Long id) {
        return userRepository.findByPkUser(id);
    }

	@Override
	public User delete(Long id) {
		User user = findById(id);
        if(user != null){
        	userRepository.deleteById(id);
        }
        return user;
	}
	

    
}
