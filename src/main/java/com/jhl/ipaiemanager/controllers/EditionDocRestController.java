package com.jhl.ipaiemanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhl.ipaiemanager.component.PdfGenerator;
import com.jhl.ipaiemanager.models.Salarie;
import com.jhl.ipaiemanager.services.SalarieService;

@RestController
@RequestMapping("/api/editions")

public class EditionDocRestController {
	@Autowired
	private PdfGenerator util;
	
	@Autowired
	private SalarieService salarieService;

	@PostMapping("salaries")
	public String getPDFView(Model model) throws Exception {
		List<Salarie> salaries = salarieService.findAll();
		Map<Object, Object> data = new HashMap<>();
		data.put("salaries", salaries);
		util.createPdf("attestation/template", data, "salaries");
		model.addAttribute("message", "PDF Downloaded successfully..");
		return "test";
	}
	
	
	@RequestMapping(path = {"/attestation_salaire/{id}"})
	public String getPDFView(Model model, @PathVariable("id") Long id) throws Exception {
		Salarie salarie = salarieService.findSalarie(id);
		Map<Object, Object> data = new HashMap<>();
		data.put("salaries", salarie);
		String filePath = util.createPdf("attestation/template", data, "salaries");
		model.addAttribute("message", "PDF Downloaded successfully..");
		return filePath;
	}

}
