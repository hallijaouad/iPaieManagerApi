package com.ipaiemanager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipaiemanager.models.Salarie;
import com.ipaiemanager.dao.SalarieRepository;

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
     * Get on salarie by id
     */
    @Override
    public Salarie findSalarie(Long id) {
        return this.salarieRepository.findSalarieById(id);
    }
    
    @Override
    @Transactional
    public Salarie create(Salarie salarie) { 
        return this.salarieRepository.save(salarie);
    }
    

    
}
