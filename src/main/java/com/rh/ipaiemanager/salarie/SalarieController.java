package com.rh.ipaiemanager.salarie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/salaries")

public class SalarieController {

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
	 * Get method with id for show detail SALARIE
	 * @param id
	 * @return
	 */
	@GetMapping(path = {"/{id}"})
    public Optional<Salarie> getSalarie(@PathVariable("id") long id){
        return salarieService.findById(id);
    }
}
