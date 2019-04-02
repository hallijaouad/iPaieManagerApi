package com.jhl.ipaiemanager.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhl.ipaiemanager.models.Salarie;
import com.jhl.ipaiemanager.services.SalarieService;



@RestController
@RequestMapping("/api/salaries")

public class SalarieRestController {

	@Autowired
	private SalarieService salarieService;		
	
	/**
	 * Get all salaries
	 * @return
	 */
	@GetMapping("")
    public List<Salarie> getAllSalaries() {	      
		return salarieService.findAll();
    }
	
	/**
	 * Get method with id for show detail salarié
	 * @param id
	 * @return
	 */
	@GetMapping(path = {"/{id}"})
    public Salarie findOne(@PathVariable("id") Long id){
        return salarieService.findSalarie(id);
    }
	
	/**
	 * Create new salarié
	 * @param salarie
	 * @return
	 */
	@PostMapping
    public Salarie create(@RequestBody Salarie salarie){			
        return salarieService.create(salarie);
    }
	
	
}
