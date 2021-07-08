package com.robertbuckley.DojoOverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.robertbuckley.DojoOverflow.models.Question;
import com.robertbuckley.DojoOverflow.services.AnswerService;
import com.robertbuckley.DojoOverflow.services.QuestionService;
import com.robertbuckley.DojoOverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	public QuestionService qService;
	@Autowired
	public AnswerService aService;
	@Autowired
	public TagService tService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("questions", this.qService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/addQuesiton")
	public String question(@ModelAttribute("questions")Question question) {
		return "AddQuestion.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String answerQuestion(Model viewModel) {
		viewModel.addAttribute("questions", this.qService.getAllQuestions());
		viewModel.addAttribute("answers", this.aService.getAllAnswers());
		viewModel.addAttribute("tags", this.tService.getAllTags());
		return "ShowQuestion.jsp";
	}
	
	@PostMapping("/addQuestion")
	public String createQuestion(@Valid @ModelAttribute("questions")Question question, BindingResult result) {
		this.qService.createQuestion(question);
//		this.qService.addTag(question, tags);
		return "redirect:/";
	}
}
