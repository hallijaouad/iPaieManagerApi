package com.jhl.ipaiemanager.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexRestController{	
	@GetMapping ("")
    public String Service(Model model) {	      
		 return "forward:/public/index.html";
    }
}