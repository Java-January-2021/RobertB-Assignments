package com.robertbuckley.BeltExam.servies;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.BeltExam.models.User;
import com.robertbuckley.BeltExam.respoitories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> findAllUsers() {
		return uRepo.findAll();
	}
//	register a user
	public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return uRepo.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	return uRepo.findById(id).orElse(null);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = uRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
