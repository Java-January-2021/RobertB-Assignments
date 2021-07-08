package com.robertbuckley.BeltExam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.robertbuckley.BeltExam.models.Idea;
import com.robertbuckley.BeltExam.models.User;
import com.robertbuckley.BeltExam.servies.IdeaService;
import com.robertbuckley.BeltExam.servies.UserService;

@Controller
@RequestMapping("/index")
public class MainController {
	@Autowired
	UserService uService;
	@Autowired
	IdeaService iService;
	
	@GetMapping("")
	public String index(@ModelAttribute("user")User user, Model viewModel, @ModelAttribute("idea")Idea idea, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
			}
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.findUserById(userId);
		List<Idea> allIdeas = iService.getAllIdeas();
		viewModel.addAttribute("ideas", allIdeas);
		viewModel.addAttribute("user", currentUser);
		return "ideas.jsp";
	}
	
	
	@GetMapping("/createIdea")
	public String cIdea(@ModelAttribute("idea")Idea idea, HttpSession session, Model viewModel) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
			}
		
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.findUserById(userId);
		viewModel.addAttribute(currentUser);
		
		return "new.jsp";
	}
	
	@PostMapping("/createIdea")
	public String createIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.iService.createIdea(idea);
		return "redirect:/index";
	}
	
	@GetMapping("/ideas/{id}")
	public String show(@PathVariable("id")Long id, @ModelAttribute("idea")Idea idea, @ModelAttribute("user")User user, HttpSession session, Model viewModel) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
			}
		Idea curentIdea = this.iService.findByid(id);
		viewModel.addAttribute("ideas", curentIdea);
		return "show.jsp"; 
	}
	
	
	@GetMapping("/like/{id}")
	public String LikeEvent(@PathVariable("id")Long id, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.findUserById(userId);
		Idea curentIdea = this.iService.findByid(id);
		viewModel.addAttribute("ideas", curentIdea);
		this.iService.likeIdea(currentUser, curentIdea);
		return "redirect:/index";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlikeIdea(@PathVariable("id")Long id, HttpSession session, Model viewModel){
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.findUserById(userId);
		Idea curentIdea = this.iService.findByid(id);
		viewModel.addAttribute("ideas", curentIdea);
		this.iService.unlikeIdea(currentUser, curentIdea);
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editIdea(@PathVariable("id")Long id, HttpSession session, Model viewModel) {
		Idea curentIdea = this.iService.findByid(id);
		Long userId = (Long) session.getAttribute("user_id");
		if(curentIdea == null || !curentIdea.getIdeaCreator().getId().equals(userId))
			return "redirect:/index";
		User user = this.iService.findById(userId);
		viewModel.addAttribute("ideas", curentIdea);
		viewModel.addAttribute("user", user);
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String editIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("ideas", idea);
			return "ideas.jsp";
		}
		this.iService.updateIdea(idea);
		return "redirect:/index/ideas/{id}";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id")Long id) {
		iService.deleteIdea(id);
		return "redirect:/index";
	}
	
}
