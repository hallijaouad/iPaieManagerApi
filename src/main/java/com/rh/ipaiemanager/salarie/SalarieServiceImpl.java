package com.rh.ipaiemanager.salarie;


import org.springframework.stereotype.Service;

import com.rh.ipaiemanager.salarie.SalarieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalarieServiceImpl implements SalarieService {

   
    private SalarieRepository salarieRepository;
    
    public SalarieServiceImpl(SalarieRepository salarieRepository){
    	this.salarieRepository = salarieRepository;
    }
    

   
    @Override
    public List<Salarie> findAll() {
    	List<Salarie> salaries = this.salarieRepository.findAll();   
        return salaries;
    }
    
    @Override
    public List<Salarie> findByNom(String nom) {
    	List<Salarie> salaries = null;
    	if(nom != ""){
    		salaries = this.salarieRepository.findByNom(nom);
    	}
        
        return salaries;
    }
    
    @Override
    public Optional<Salarie> findById(long id) {
        return this.salarieRepository.findById(id);
    }
    
    @Override
    public Optional<Salarie> delete(long id) {
    	Optional<Salarie> salarie = this.salarieRepository.findById(id);
        if(salarie != null){
        	this.salarieRepository.delete(salarie);
        }
        return salarie;
    }

    
}
