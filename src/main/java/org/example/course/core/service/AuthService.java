package org.example.course.core.service;

import lombok.RequiredArgsConstructor;
import org.example.course.core.dto.user.RegisterRequest;
import org.example.course.core.entity.user.Role;
import org.example.course.core.entity.user.User;
import org.example.course.core.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Şifre Hash'leniyor
        user.setRole(Role.STUDENT);

        userRepository.save(user);
        return "User registered successfully";
    }
}
