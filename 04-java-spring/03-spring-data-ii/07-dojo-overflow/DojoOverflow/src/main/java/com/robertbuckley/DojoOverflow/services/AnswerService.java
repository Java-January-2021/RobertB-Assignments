package com.robertbuckley.DojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.DojoOverflow.models.Answer;
import com.robertbuckley.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
	
	public Answer createAnswer(Answer newAnswer) {
		return this.aRepo.save(newAnswer);
	}
}
