package com.jhl.ipaiemanager.services;

import java.util.List;

import com.jhl.ipaiemanager.models.Salarie;



public interface SalarieService {
	// Method find all salarie
	List<Salarie> findAll();
	// Filtre les salariés
	List<Salarie> findByNomLike(String nom);
	// Search Salarie by id
	Salarie findSalarie(Long id);
	//Create slarie
	Salarie create (Salarie salarie);
	//Upadate salarie
	Salarie update (Salarie salarie);
	//Delete salarie
	Salarie delete (Long id);
	
}
