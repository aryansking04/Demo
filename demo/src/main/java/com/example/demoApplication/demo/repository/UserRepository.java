package com.example.demoApplication.demo.repository;

import com.example.demoApplication.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // ✅ Ensure this is present
}
