package com.ipaiemanager.services;

import java.util.List;

import com.ipaiemanager.models.Salarie;



public interface SalarieService {
	// Method find all salarie
	List<Salarie> findAll();
	// Search Salarie by id
	Salarie findSalarie(Long id);
	//Create slarie
	Salarie create (Salarie salarie);
	
}
