package com.robertbuckley.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robertbuckley.languages.models.Language;
import com.robertbuckley.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String getAllLanguages(Model viewModel){
		List<Language> languages = lService.getAllLanguages();
		viewModel.addAttribute("languages", languages);
		return "Home.jsp";
	}
	@GetMapping("/add")
	public String addLanguage(@ModelAttribute("languages")Language language) {
		return "add.jsp";
	}
	@PostMapping("/add")
	public String createLanguage(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		else {
			this.lService.createLanguage(language);
			return "redirect:/";
		}
	}
	@DeleteMapping("/delete/{id}")
	public void deleteLanguage(@PathVariable("id") long id) {
		this.lService.deleteLanguage(id);
	}
	
	@RequestMapping("/language/delete/{id}")
	public String eraseLanguage(@PathVariable("id") long id, @ModelAttribute("languages") Language language) {
		lService.deleteLanguage(id);
		return "redirect:/";
	}
	@RequestMapping("/language/edit/{id}")
	public String editLanguage(@PathVariable("id") long id, @ModelAttribute("languages") Language language) {
		Language languageToUpdate = lService.getOneLanguage(id);
		if(languageToUpdate != null) {
			return "edit.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	@PostMapping("/language/edit/{id}")
	public String updateLanguage(@PathVariable("id")long id, @Valid @ModelAttribute("languages")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			this.lService.updateLanguage(id, language);
			return "redirect:/";
		}
	}
	@RequestMapping("/language/{id}")
	public String showOneLanguage(@PathVariable("id")long id, Model viewModel) {
		Language showLanguage = this.lService.getOneLanguage(id);
		viewModel.addAttribute("Language", showLanguage);
		return "ShowOne.jsp";
	}
	
}

// just need to add the show one language

	
