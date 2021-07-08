package com.robertbuckley.BeltExam.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.BeltExam.models.Idea;
import com.robertbuckley.BeltExam.models.User;
import com.robertbuckley.BeltExam.respoitories.IdeaRepository;
import com.robertbuckley.BeltExam.respoitories.UserRepository;

@Service
public class IdeaService {
	@Autowired
	UserRepository uRepo;
	@Autowired
	IdeaRepository iRepo;
	
	public List<User> findAllUsers(){
		return this.uRepo.findAll();
	}
	
	public List<Idea> getAllIdeas(){
		return this.iRepo.findAll();
		}
	
	public User findById(Long id){
		return this.uRepo.findById(id).orElse(null);
	}
	
	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public Idea findByid(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public void likeIdea(User user, Idea idea) {
		List<User> userToLikeIdea = idea.getUsersLiked();
		userToLikeIdea.add(user);
		this.iRepo.save(idea);
	}
	
	public void unlikeIdea(User user, Idea idea) {
		List<Idea> ideaToUnlike = user.getIdea();
		ideaToUnlike.remove(idea);
		this.uRepo.save(user);
	}
	
	public Idea updateIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	
}
