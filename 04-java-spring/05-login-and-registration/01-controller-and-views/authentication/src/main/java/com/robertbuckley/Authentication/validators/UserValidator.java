package com.robertbuckley.Authentication.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.robertbuckley.Authentication.models.User;
import com.robertbuckley.Authentication.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	UserRepository uRepo;
	
	public boolean support(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Passwords do not match!");
		}
		
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "This email is already in use!");
		}
		
	}

}
