package com.jhl.ipaiemanager.services;
import java.util.List;
import java.util.Optional;

import com.jhl.ipaiemanager.models.Utilisateur;

public interface UserService {
	List<Utilisateur> getAllUsers();
	List<Utilisateur> findByNom(String nom);
	Utilisateur create (Utilisateur user);
	Utilisateur update (Utilisateur user);	
	Optional<Utilisateur> delete(Long id);
	Optional<Utilisateur> findById(Long id);	
	Utilisateur getUserByEmail(String email);
}
