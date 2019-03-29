package com.rh.ipaiemanager.salarie;
import java.util.List;



public interface SalarieService {
	List<Salarie> findAll();
	List<Salarie> findByNom(String nom);
	Salarie getSalarieById(long id);	
	Salarie delete(long id);
}
