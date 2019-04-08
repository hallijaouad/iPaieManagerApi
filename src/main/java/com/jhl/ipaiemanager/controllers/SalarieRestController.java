package com.jhl.ipaiemanager.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhl.ipaiemanager.exceptions.ResourceNotFoundException;
import com.jhl.ipaiemanager.models.Salarie;

import com.jhl.ipaiemanager.services.SalarieService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/salaries")

public class SalarieRestController {

	@Autowired
	private SalarieService salarieService;		
	
	/**
	 * Get all salaries
	 * @return
	 */
	@GetMapping ("")
    public List<Salarie> getAllSalaries() {	      
		return salarieService.findAll();
    }
	
	@GetMapping (path = "/filtre/{nom}")
	public List<Salarie> getSalaries(@PathVariable(name = "nom", value = "nom") String nom){
		if(nom != null){
			return salarieService.findByNomLike("%" + nom + "%");			
		}
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
	@PostMapping(path = "")
    public Salarie create(@Valid @RequestBody Salarie salarie){			
        return salarieService.create(salarie);
    }
	
	@PutMapping(path = "{id}")
    public Salarie update(@PathVariable(value = "id") Long id, @Valid @RequestBody Salarie salarie) throws URISyntaxException{
		Salarie salarieDba = salarieService.findSalarie(id);
		if(salarieDba.getId() == null){
			throw new ResourceNotFoundException("Salarie non trouvé " + id);
		}
		salarieDba.setMatricule(salarie.getMatricule());
		salarieDba.setNom(salarie.getNom());
		salarieDba.setPrenom(salarie.getPrenom());
		salarieDba.setEmail(salarie.getEmail());
		salarieDba.setDate_embauche(salarie.getDate_embauche());
		salarieDba.setMobile(salarie.getMobile());
        return salarieService.update(salarieDba);
    }
	
	/**
	 * Suppression d'un salarie
	 * @param id
	 * @return Salarie salaie
	 */
	@DeleteMapping(path = "/{id}")
	public Salarie delete(@PathVariable("id") Long id){
		Salarie salarieDba = salarieService.findSalarie(id);
		if(salarieDba.getId() == null){
			throw new ResourceNotFoundException("Salarie non trouvé " + id);
		}
		return salarieService.delete(id);
	}
	
	
}
