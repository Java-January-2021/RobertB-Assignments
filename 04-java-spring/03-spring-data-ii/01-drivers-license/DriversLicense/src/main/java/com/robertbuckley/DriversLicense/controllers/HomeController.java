package com.robertbuckley.DriversLicense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robertbuckley.DriversLicense.models.DLModels;
import com.robertbuckley.DriversLicense.models.LicenseModels;
import com.robertbuckley.DriversLicense.services.DriversLicenseService;

@Controller
public class HomeController {
	@Autowired
	private DriversLicenseService DLService;
	
	@GetMapping("/")
	private String index(@ModelAttribute("persons")DLModels person) {
		return "new.jsp";
	}
	
	@PostMapping("/add")
	private String addPerson(@ModelAttribute("persons")DLModels person) {
		this.DLService.createPerson(person);
		return "redirect:/license";
	}
	
	@RequestMapping("/license")
	private String license(@ModelAttribute("license")LicenseModels license, Model viewModel) {
		List<DLModels> unlicense = DLService.getUnlicensedPeople();
		viewModel.addAttribute("persons", unlicense);
		return "newLicense.jsp";
		
	}
	@PostMapping("/addLicense")
	private String addLicense(@ModelAttribute("license")LicenseModels license) {
		this.DLService.createLicense(license);
		return "redirect:/showLicense{id}";
		
	}
	
	@RequestMapping("/{id}")
	private String showLicense(@PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("person", DLService.getOnePerson(id));
		return "show.jsp";
	}
	
	
}
