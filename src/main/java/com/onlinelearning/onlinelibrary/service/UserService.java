package com.onlinelearning.onlinelibrary.service;

import com.onlinelearning.onlinelibrary.dto.User;
import com.onlinelearning.onlinelibrary.exception.BadCredentialsException;
import com.onlinelearning.onlinelibrary.exception.NoUserFoundException;
import com.onlinelearning.onlinelibrary.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }
    public User loginUser(User user) throws NoUserFoundException {
        Optional<User>  optionalUser = userRepo.getUserByUserName(user.getUserName()); // <User>
        if (optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            if (existingUser.getUserPassword().equals(user.getUserPassword())) {
                return existingUser;
            }
            else {
                throw  new BadCredentialsException("Password doesn't match");
            }
        }
        else {
            throw  new NoUserFoundException("User Not found in system");
        }
    }

}
