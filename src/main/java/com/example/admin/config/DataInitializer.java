package com.example.admin.config;

import com.example.admin.entity.Users;
import com.example.admin.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // 관리자 계정이 없으면 생성
        if (!userRepository.existsByUsername("admin")) {
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("");
            admin.setFullName("관리자");
            admin.setRole("ADMIN");
            admin.setIsEnabled(true);
            userRepository.save(admin);
            System.out.println("=================================");
            System.out.println("관리자 계정이 생성되었습니다!");
            System.out.println("Username: admin");
            System.out.println("Password: admin123");
            System.out.println("=================================");
        }
    }
}