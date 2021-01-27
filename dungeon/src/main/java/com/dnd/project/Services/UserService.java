package com.dnd.project.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.dnd.project.Models.User;
import com.dnd.project.Repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
