package com.robertbuckley.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private String[] getLanguages() {
		return new String[] {
				"C#", "Python", "Java", "C++"
		};
	}
	private String[] getLocations() {
		return new String[] {
				"Chicago", "Seattle", "San Jose", "Online"
		};
	}
	@GetMapping("/")
	public String main(Model viewModel) {
		viewModel.addAttribute("lang", getLanguages());
		viewModel.addAttribute("location", getLocations());
		return "index.jsp";
	}
	@RequestMapping(value = "/submit", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="lang") String lang, @RequestParam(value="comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("lang", lang);
		session.setAttribute("comment", comment);
		
		
		return "redirect:/result";
		
	}
	@RequestMapping(value = "/result", method=RequestMethod.GET)
	public String result(HttpSession session, Model viewModel) {
		String name = (String)session.getAttribute("name");
		String location = (String)session.getAttribute("location");
		String lang = (String)session.getAttribute("lang");
		String comment = (String)session.getAttribute("comment");
		if(lang.equals("Java")) {
			return "java.jsp";
		}
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("lang", lang);
		viewModel.addAttribute("comment", comment);
		System.out.println(name);
		System.out.println(location);
		System.out.println(lang);
		System.out.println(comment);
		return "result.jsp";
		
	}
}
