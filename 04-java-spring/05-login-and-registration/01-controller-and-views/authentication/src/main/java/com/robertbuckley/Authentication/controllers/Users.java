package com.robertbuckley.Authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robertbuckley.Authentication.models.User;
import com.robertbuckley.Authentication.services.UserService;

@Controller
public class Users {
	@Autowired
	private UserService uService;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
		if(result.hasErrors()) {
			return "/registraion";
		}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	boolean isAuthenticated = uService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User user = uService.findByEmail(email);
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	model.addAttribute("error", "Invalid login information. Try Again!");
    	return "redirect:/login";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long setUser = (Long) session.getAttribute("user_id");
    	User user = uService.findUserById(setUser);
    	model.addAttribute("user", user);
    	return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
