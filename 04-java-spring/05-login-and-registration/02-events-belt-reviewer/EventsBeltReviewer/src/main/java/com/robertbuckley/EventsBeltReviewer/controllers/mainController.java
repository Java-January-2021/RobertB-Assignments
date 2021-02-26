package com.robertbuckley.EventsBeltReviewer.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robertbuckley.EventsBeltReviewer.models.Event;
import com.robertbuckley.EventsBeltReviewer.models.Message;
import com.robertbuckley.EventsBeltReviewer.models.State;
import com.robertbuckley.EventsBeltReviewer.models.User;
import com.robertbuckley.EventsBeltReviewer.services.AllServices;
import com.robertbuckley.EventsBeltReviewer.services.UserService;

@Controller
public class mainController {
	@Autowired 
	private UserService uServ;
	@Autowired
	private AllServices aServ;
	
	// push through event data
	@GetMapping("/createEvent")
	public String eventPage(@ModelAttribute("user")User user, Model viewModel, @ModelAttribute("event") Event event,HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long setUser = (Long)session.getAttribute("user_id");
		User currentUser = uServ.findUserById(setUser);
		List<Event>allEvents = aServ.getAllEvents();
		viewModel.addAttribute("user_id", setUser);
		viewModel.addAttribute("user", currentUser);
		viewModel.addAttribute("events", allEvents);
		viewModel.addAttribute("states", State.States);
		viewModel.addAttribute("userState", this.aServ.eventsByInState(currentUser.getState()));
		viewModel.addAttribute("nonUserState", this.aServ.eventsNotInState(currentUser.getState()));
		return "events.jsp";
	}
	
	//creating event
	@PostMapping("/createEvent")
	public String newEvent(@Valid @ModelAttribute("event")Event event,BindingResult result, HttpSession session,  Model viewModel) {
		if(result.hasErrors()) {
			Long setUser = (Long)session.getAttribute("user_id");
			User currentUser = uServ.findUserById(setUser);
			List<Event>allEvents = aServ.getAllEvents();
			viewModel.addAttribute("user_id", setUser);
			viewModel.addAttribute("user", currentUser);
			viewModel.addAttribute("events", allEvents);
			viewModel.addAttribute("states", State.States);
			viewModel.addAttribute("userState", this.aServ.eventsByInState(currentUser.getState()));
			viewModel.addAttribute("nonUserState", this.aServ.eventsNotInState(currentUser.getState()));
			return "events.jsp";
		}
		this.aServ.createEvent(event);
		return "redirect:/events";
			
	}
	
	@GetMapping("/join/{id}")
	public String joinEvent(@PathVariable("id")Long id, HttpSession session, Model viewModel) {
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = aServ.getOneEvent(id);
		User user = aServ.getOneUser(user_id);
		viewModel.addAttribute("user", user);
		this.aServ.addEventToUser(user, event);
		return "redirect:/createEvent";
	}
	
	@GetMapping("/unjoin/{id}")
	public String leaveEvent(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = aServ.getOneEvent(id);
		User user = aServ.getOneUser(user_id);
		this.aServ.removeEventFromUser(user, event);
		return "redirect:/createEvent";
	}
	
	@GetMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable("id")Long id) {
		aServ.deleteEvent(id);
		return "redirect:/createEvent";
	}
	
	@GetMapping("/show/{id}")
	public String showEvent(@PathVariable("id")Long id, Model viewModel, HttpSession session, @ModelAttribute("message")Message message) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = aServ.getOneEvent(id);
		User user = aServ.getOneUser(user_id);
		List<Message>eventMessages = aServ.getAllMessages();
		viewModel.addAttribute("messages", eventMessages);
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("event", event);
		return "showEvent.jsp";
	}
	
	@PostMapping("/addMessage/{id}")
	public String addMessage(@RequestParam("content")String content,@PathVariable("id")Long id, RedirectAttributes redirects, Model viewModel, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = aServ.getOneEvent(id);
		User user = aServ.getOneUser(user_id);
		if(user_id==null)
			return "redirect:/";
		if(content.equals("")) {
			redirects.addFlashAttribute("error", "Message must not be blank!");
			return "redirect:/show/" + id;
		}
		this.aServ.createMessage(user, content, event);
		return "redirect:/show/" + id;
	}
	
	@GetMapping("update/{id}")
	public String showEditEvent(@PathVariable("id")Long id, Model viewModel, @ModelAttribute("event")Event event, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) session.getAttribute("user_id");
		Event eventToEdit = aServ.getOneEvent(id);
		User user = aServ.getOneUser(user_id);
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("event",eventToEdit);
		viewModel.addAttribute("states", State.States);
		return "edit.jsp";
	}
	
	@PostMapping("update/{id}")
	public String editEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("event", event);
			viewModel.addAttribute("states", State.States);
			return "edit.jsp";
		}
		this.aServ.updateEvent(event);
		return "redirect:/show/" + id;
	}
}
