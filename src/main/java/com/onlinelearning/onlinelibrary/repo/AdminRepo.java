package com.onlinelearning.onlinelibrary.repo;

import com.onlinelearning.onlinelibrary.dto.Admin;
import com.onlinelearning.onlinelibrary.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findByAdminName(String adminName);

    Optional<Admin> getAdminByAdminName(String adminName);

}
