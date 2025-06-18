package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
