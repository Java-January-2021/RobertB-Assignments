package com.robertbuckley.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robertbuckley.lookify.models.LookifyModels;
import com.robertbuckley.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	public LookifyRepository lRepo;
	
	public LookifyService(LookifyRepository repo) {
		this.lRepo = repo;
	}
	
	public List<LookifyModels> getAllItems(){
		return this.lRepo.findAll();
	}
	
	public LookifyModels getOne(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public LookifyModels createLookify(LookifyModels newLookify) {
		return this.lRepo.save(newLookify);
	}
	
	public void deleteLookify(Long id) {
		this.lRepo.deleteById(id);
	}
	
	public LookifyModels updateLookify(Long id, LookifyModels lookifyToUpdate) {
		return this.lRepo.save(lookifyToUpdate);
	}
	
	public List<LookifyModels> findByArtist(String artist) {
		return this.lRepo.findByArtistContaining(artist);
	}
	
	public List<LookifyModels> findTopTen(){
		return this.lRepo.findTop10ByOrderByRatingDesc();
	}
	
}
