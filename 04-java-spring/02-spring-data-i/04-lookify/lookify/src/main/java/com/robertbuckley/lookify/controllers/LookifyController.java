package com.robertbuckley.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.robertbuckley.lookify.models.LookifyModels;
import com.robertbuckley.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	private LookifyService lService;
	
	@RequestMapping("/")
	public String mainPage() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String getAllLookify(Model viewModel) {
		List<LookifyModels> lookify = lService.getAllItems();
		viewModel.addAttribute("lookify", lookify);
		return "main.jsp";
	}
	
	@GetMapping("/add")
	public String addLookify(@ModelAttribute("lookify")LookifyModels lookify) {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String addNewLookify(@Valid @ModelAttribute("lookify")LookifyModels lookify, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			this.lService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/dashboard/delete/{id}")
	public String deleteLookify(@PathVariable("id") long id) {
		lService.deleteLookify(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/{id}")
	public String showInfo(@PathVariable("id")long id, Model viewModel) {
		LookifyModels info = lService.getOne(id);
		viewModel.addAttribute("lookify", info);
		return "showInfo.jsp";
	}
	
	@RequestMapping("/topsongs")
	public String top10InOrder(Model viewModel) {
		viewModel.addAttribute("lookify", lService.findTopTen());
		return "top10InOrder.jsp";
	}
	
	@RequestMapping("/search")
	public String searchByArtist(@RequestParam("artist") String artist, Model viewModel) {
		viewModel.addAttribute("lookify", lService.findByArtist(artist));
		viewModel.addAttribute("artist", artist);
		return "searchByArtist.jsp";
	}
}
