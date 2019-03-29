package com.rh.ipaiemanager.salarie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rh.ipaiemanager.salarie.SalarieRepository;

import java.util.List;


@Service
public class SalarieServiceImpl implements SalarieService {

	@Autowired
    private SalarieRepository salarieRepository;
    
    public SalarieServiceImpl(SalarieRepository salarieRepository){
    	this.salarieRepository = salarieRepository;
    }
    

   /**
    * Find all ressources salariés
    */
    @Override
    public List<Salarie> findAll() {
    	List<Salarie> salaries = this.salarieRepository.findAll();   
        return salaries;
    }
    
    /**
     * Filtre les salriés par nom
     */
    
    @Override
    public List<Salarie> findByNom(String nom) {
    	List<Salarie> salaries = null;
    	if(nom != ""){
    		salaries = this.salarieRepository.findByNom(nom);
    	}
        
        return salaries;
    }
    
    /**
     * Get données d'un salariés
     */
    @Override
    public Salarie getSalarieById(long id) {
    	return this.salarieRepository.findOne(id);
    }
    
    
    /**
     * Supprimer le salariés by identificateur
     */
    @Override
    public Salarie delete(long id) {
    	Salarie salarie = getSalarieById(id);
        if(salarie != null){
        	this.salarieRepository.delete(salarie);
        }
        return salarie;
    }

    
}
