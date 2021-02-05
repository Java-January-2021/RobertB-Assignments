package com.robertbuckley.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robertbuckley.languages.models.Language;
import com.robertbuckley.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	public List<Language> getAllLanguages() {
		return this.lRepo.findAll();
	}
	
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	public Language updateLanguage(Long id, Language languageToUpdate) {
		return this.lRepo.save(languageToUpdate);
	}
	
}
