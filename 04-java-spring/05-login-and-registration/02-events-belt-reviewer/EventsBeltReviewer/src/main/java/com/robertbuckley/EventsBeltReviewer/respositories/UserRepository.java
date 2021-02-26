package com.robertbuckley.EventsBeltReviewer.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.EventsBeltReviewer.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByEmail(String email);
	boolean existsByEmail(String email);
	


}
