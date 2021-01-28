package com.robertbuckley.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counter {
	@RequestMapping("/")
	public String main(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String index(HttpSession session, Model viewModel) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		session.setAttribute("count", currentCount);
		viewModel.addAttribute("currentCount");
		return "counter.jsp";
		
	}
}
