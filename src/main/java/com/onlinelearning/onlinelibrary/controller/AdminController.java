package com.onlinelearning.onlinelibrary.controller;

import com.onlinelearning.onlinelibrary.dto.Admin;
import com.onlinelearning.onlinelibrary.exception.NoUserFoundException;
import com.onlinelearning.onlinelibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping("/registerAdmin")
    public ResponseEntity<Admin> registerAdmin(Admin admin){
        return ResponseEntity.ok(adminService.registerAdmin(admin));
    }
    @PostMapping("/loginAdmin")
    public ResponseEntity<Admin> loginAdmin(Admin admin) throws  NoUserFoundException {
        return ResponseEntity.ok(adminService.loginAdmin(admin));
    }
}
