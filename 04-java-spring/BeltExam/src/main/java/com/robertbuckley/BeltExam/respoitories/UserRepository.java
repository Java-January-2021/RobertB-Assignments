package com.robertbuckley.BeltExam.respoitories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.BeltExam.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByEmail(String email);
	boolean existsByEmail(String email);
}
