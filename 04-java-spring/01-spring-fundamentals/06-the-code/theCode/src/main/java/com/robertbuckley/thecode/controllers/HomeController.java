package com.robertbuckley.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String main() {
		return "main.jsp";
	}
	@RequestMapping(path="/codeWord", method=RequestMethod.POST)
	public String index(@RequestParam(value="codeWord") String codeWord, RedirectAttributes errors) {
		if(codeWord.contentEquals("bushido")) {
			return "redirect:/code";
		} else {
			errors.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}

}

