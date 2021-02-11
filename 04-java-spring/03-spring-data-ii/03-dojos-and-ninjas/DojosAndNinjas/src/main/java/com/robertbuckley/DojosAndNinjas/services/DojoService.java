package com.robertbuckley.DojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.DojosAndNinjas.models.Dojo;
import com.robertbuckley.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	public List<Dojo> getAll(){
		return this.dRepo.findAll();
	}
	public Dojo createEntry(Dojo newEntry) {
		return this.dRepo.save(newEntry);
	}

	public Dojo getById(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public Dojo updateEntry(Dojo toUpdate) {
		return this.dRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.dRepo.deleteById(id);
	}
	
}