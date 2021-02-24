package com.robertbuckley.Authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.Authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	// in order to find by email we have to use the findBy
	User findByEmail(String email);

}
