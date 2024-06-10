package com.onlinelearning.onlinelibrary.controller;


import com.onlinelearning.onlinelibrary.dto.User;
import com.onlinelearning.onlinelibrary.exception.NoUserFoundException;
import com.onlinelearning.onlinelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(User user) throws  NoUserFoundException {
        return ResponseEntity.ok(userService.loginUser(user));
    }
}
