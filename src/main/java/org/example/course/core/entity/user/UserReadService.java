package org.example.course.core.entity.user;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.entity.user.dto.UserReadRequestDto;
import org.example.course.core.entity.user.dto.UserReadResponseDto;
import org.example.course.core.repository.UserRepository;
import org.example.course.utility.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class UserReadService {
    UserRepository userRepository;

    public UserReadResponseDto read(UserReadRequestDto dto) {
        User user = userRepository.findById(dto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        if (userRepository.findById(dto.getId()).isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return UserReadResponseDto.builder()
                .username(user.getUsername())
                .build();
    }
}
