package com.robertbuckley.Authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.Authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	// in order to find by email we have to use the findBy
	User findByEmail(String email);
	boolean existsByEmail(String email);
	

}
