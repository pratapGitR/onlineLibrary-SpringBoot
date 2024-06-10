package com.onlinelearning.onlinelibrary.service;

import com.onlinelearning.onlinelibrary.dto.Admin;
import com.onlinelearning.onlinelibrary.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public ResponseEntity<Admin> registerAdmin(Admin admin) {
        return ResponseEntity.ok(adminRepo.save(admin));
    }

    public ResponseEntity<Admin> loginAdmin(Admin admin) {
        Admin existingAdmin = adminRepo.findByAdminName(admin.getAdminName());
        if (existingAdmin != null && existingAdmin.getAdminPassword().equals(admin.getAdminPassword())) {
            return ResponseEntity.ok(existingAdmin);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
