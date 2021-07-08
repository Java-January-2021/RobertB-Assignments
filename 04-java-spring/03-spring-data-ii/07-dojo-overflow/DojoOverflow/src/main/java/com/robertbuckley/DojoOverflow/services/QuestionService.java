package com.robertbuckley.DojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.DojoOverflow.models.Answer;
import com.robertbuckley.DojoOverflow.models.Question;
import com.robertbuckley.DojoOverflow.models.Tag;
import com.robertbuckley.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	
	public QuestionService(QuestionRepository repo) {
		this.qRepo = repo;
	}
	
	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
	
	public Question createQuestion(Question newQuestion) {
		return this.qRepo.save(newQuestion);
	}
	
	public Question findQuestionById(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public void addTag(Question question, Tag tag) {
		List<Tag> tags = question.getTags();
		tags.add(tag);
		this.qRepo.save(question);
	}
	
	public void addAnswer(Question question, Answer answer) {
		List<Answer> answers = question.getAnswers();
		answers.add(answer);
		this.qRepo.save(question);
	}
	
}
