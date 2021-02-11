package com.robertbuckley.DojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robertbuckley.DojosAndNinjas.models.Dojo;
import com.robertbuckley.DojosAndNinjas.models.Ninja;
import com.robertbuckley.DojosAndNinjas.services.DojoService;
import com.robertbuckley.DojosAndNinjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/")
	public String mainPage(@ModelAttribute("dojos") Dojo dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/add")
	public String createDojo(@ModelAttribute("dojos") Dojo dojo) {
		this.dService.createEntry(dojo);
		return "redirect:/ninja";
		
	}
	
	@GetMapping("/ninja")
	public String ninja(@ModelAttribute("ninjas")Ninja ninja, Model viewModel, BindingResult result) {
		List<Dojo> allDojo = dService.getAll();
		viewModel.addAttribute("allDojos", allDojo);
		System.out.println(allDojo);
		return "addNinja.jsp";
	}
	
	@PostMapping("/addNinja")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja) {
		this.nService.createEntry(ninja);
		return "redirect:/";
	}
	
	
	@GetMapping("/showDojos/{id}")
    public String showDojos(@PathVariable("id") Long id, Model viewModel) {
        Dojo dojo = dService.getById(id);
        List<Ninja> ninja = dojo.getNinjas();
        viewModel.addAttribute("dojo", dojo);
        viewModel.addAttribute("ninjas", ninja);
        return "/show.jsp";
	}

}
