package com.robertbuckley.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.lookify.models.LookifyModels;

public interface LookifyRepository extends CrudRepository<LookifyModels, Long> {
	List<LookifyModels> findAll();
	List<LookifyModels> findTop10ByOrderByRatingDesc();
	List<LookifyModels> findByArtistContaining(String artist);
}
