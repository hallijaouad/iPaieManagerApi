package com.jhl.ipaiemanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

	@RequestMapping("/generatePDF")
	public String getPDFView(Model model) throws Exception {
		List<Salarie> salaries = salarieService.findAll();
		Map<Object, Object> data = new HashMap<>();
		data.put("salaries", salaries);
		util.createPdf("attestion/tepmlate", data, "salaries");
		model.addAttribute("message", "PDF Downloaded successfully..");
		return "test";
	}

}
