package com.example.demoApplication.demo.service;

import com.example.demoApplication.demo.model.User;
// import com.example.demoApplication.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@Transactional
public class UserServiceTest implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password123"); // Note: Ideally, passwords should be hashed.
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDob(LocalDate.of(1995, 8, 12));
        user.setAddressLine1("Street 1");
        user.setAddressLine2("City Center");
        user.setAddressLine3("State");
        user.setPostalCode("123456");
        user.setPhoneNumber("9876543210");

        try {
            User savedUser = userService.registerUser(user);
            System.out.println("✅ User registered successfully: " + savedUser.getUsername());
        } catch (Exception e) {
            System.err.println("❌ Error registering user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
