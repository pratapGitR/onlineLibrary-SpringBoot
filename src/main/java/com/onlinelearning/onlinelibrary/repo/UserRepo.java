package com.onlinelearning.onlinelibrary.repo;

import com.onlinelearning.onlinelibrary.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String userName);

    Optional<User> getUserByUserName(String userName);
}
