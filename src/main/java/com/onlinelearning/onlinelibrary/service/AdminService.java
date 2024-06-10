package com.onlinelearning.onlinelibrary.service;

import com.onlinelearning.onlinelibrary.dto.Admin;
import com.onlinelearning.onlinelibrary.exception.BadCredentialsException;
import com.onlinelearning.onlinelibrary.exception.NoUserFoundException;
import com.onlinelearning.onlinelibrary.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public Admin registerAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin loginAdmin(Admin admin) throws NoUserFoundException {
        Optional<Admin>  optionalAdmin= adminRepo.getAdminByAdminName(admin.getAdminName());
        if (optionalAdmin.isPresent()) {
            Admin adminEntity = optionalAdmin.get();
            if (adminEntity.getAdminPassword().equals(admin.getAdminPassword())) {
                return adminEntity;
            }
            else {
                throw new BadCredentialsException("Password doesn't match");
            }
        }
        else {
           throw new NoUserFoundException("User Not found in system");
        }
    }
}
