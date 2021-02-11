package com.robertbuckley.DojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.DojosAndNinjas.models.Ninja;
import com.robertbuckley.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public List<Ninja> getAll(){
		return this.nRepo.findAll();
	}
	
	public Ninja createEntry(Ninja newEntry) {
		return this.nRepo.save(newEntry);
	}
	
	public Ninja getById(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	public Ninja updateEntry(Ninja toUpdate) {
		return this.nRepo.save(toUpdate);
	}
	
	public void deleteById(Long id) {
		this.nRepo.deleteById(id);
	}
	
}
