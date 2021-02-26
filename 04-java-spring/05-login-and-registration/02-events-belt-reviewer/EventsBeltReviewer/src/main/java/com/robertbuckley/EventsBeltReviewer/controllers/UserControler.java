package com.robertbuckley.EventsBeltReviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robertbuckley.EventsBeltReviewer.models.State;
import com.robertbuckley.EventsBeltReviewer.models.User;
import com.robertbuckley.EventsBeltReviewer.services.UserService;
import com.robertbuckley.EventsBeltReviewer.validators.UserValidator;

@Controller
public class UserControler {
		@Autowired 
		private UserService uServ;
		
		@Autowired
		private UserValidator uValid;
		
		@GetMapping("/")
		public String mainPage(@ModelAttribute("user")User emptyUser, Model viewModel) {
			viewModel.addAttribute("states", State.States);
			return "mainPage.jsp";
		}
		
		@PostMapping("/register")
		public String processRegister(@Valid @ModelAttribute("user")User filledUser, BindingResult results, HttpSession session, Model viewModel) {
			uValid.validate(filledUser, results);
			viewModel.addAttribute("states", State.States);
			if(results.hasErrors()) {
				return "mainPage.jsp";
			}
//			CREATE USER
			User newUser = uServ.registerUser(filledUser);
//			SAVE THE USER'S ID IN SESSION THEN REDIRECT TO DASHBOARD
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/createEvent";
		}

		@PostMapping("/login")
		public String processLogin(@RequestParam("email")String postEmail,@RequestParam("password")String postPassword,RedirectAttributes redirectAttributes,HttpSession session) {
//			IF EMAIL IS NOT FOUND OR IF PASSWORD DOES NOT MATCH
			if( !this.uServ.authenticateUser(postEmail, postPassword)) {
				redirectAttributes.addFlashAttribute("error", "INVALID CREDENTIALS");
				return "redirect:/";
			}
//			FIND USER FROM DB AND THEN SET USER ID IN SESSION
			User loggedUser = uServ.findByEmail(postEmail);
			session.setAttribute("user_id", loggedUser.getId());
			return "redirect:/createEvent";
		}
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
}
