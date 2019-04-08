package com.jhl.ipaiemanager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhl.ipaiemanager.models.Salarie;
import com.jhl.ipaiemanager.dao.SalarieRepository;

import java.util.List;

import javax.transaction.Transactional;


@Service
public class SalarieServiceImpl implements SalarieService {

	@Autowired
    private SalarieRepository salarieRepository;    

   /**
    * Get all salariés
    */
    @Override
    public List<Salarie> findAll() {
    	List<Salarie> salaries = this.salarieRepository.findAll();   
        return salaries;
    }  
    
    /**
     * Filtrer les salariés par nom
     */
     @Override
     public List<Salarie> findByNomLike(String nom) {
     	List<Salarie> salaries = this.salarieRepository.findByNomLike(nom);   
         return salaries;
     }  
    
    /**
     * Get on salarie by id
     */
    @Override
    public Salarie findSalarie(Long id) {
        return this.salarieRepository.findSalarieById(id);
    }
    
    /**
     * Création d'un nouveau salarié
     */
    @Override
    @Transactional
    public Salarie create(Salarie salarie) { 
        return this.salarieRepository.save(salarie);
    }
    
    /**
     * Update salarié
     */
    @Override
    @Transactional
    public Salarie update(Salarie salarie) { 
        return this.salarieRepository.save(salarie);
    }
    
    /**
     * Supression d'un salarié
     */
    @Override
    public Salarie delete(Long id){
    	Salarie salarie = findSalarie(id);
    	// si salarié est existe
    	if(salarie.getId() > 0){
    		this.salarieRepository.deleteById(id);
    	}
    	return salarie;
    }
    

    
}
