package com.onlinelearning.onlinelibrary.service;

import com.onlinelearning.onlinelibrary.dto.User;
import com.onlinelearning.onlinelibrary.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }
    public ResponseEntity<User> loginUser(User user) {
        User existingUser = userRepo.findByUserName(user.getUserName());
        if (existingUser != null && existingUser.getUserPassword().equals(user.getUserPassword())) {
            return ResponseEntity.ok(existingUser);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
