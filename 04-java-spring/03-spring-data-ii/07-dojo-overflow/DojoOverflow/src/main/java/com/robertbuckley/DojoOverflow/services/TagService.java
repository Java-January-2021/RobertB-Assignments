package com.robertbuckley.DojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.DojoOverflow.models.Tag;
import com.robertbuckley.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	public TagRepository tRepo;
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	public Tag createTag(Tag newTag) {
		return this.tRepo.save(newTag);
	}

}
