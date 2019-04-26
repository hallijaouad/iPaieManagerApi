package com.jhl.ipaiemanager.dao;
import com.jhl.ipaiemanager.models.Utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Utilisateur, Long>{
	List<Utilisateur> findByNom(String nom);	
	Utilisateur findByEmail(String email);
	Optional<Utilisateur> findById(Long id);
}
