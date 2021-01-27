package com.robertbuckley.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/{name}")
	public String showName(@PathVariable(value="name", required = false) String userName, Model viewModel) {
		viewModel.addAttribute("userName", userName);
		System.out.println(userName);
		return "index.jsp";
	}
}
