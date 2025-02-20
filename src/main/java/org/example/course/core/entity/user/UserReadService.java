package org.example.course.core.entity.user;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.entity.user.dto.UserReadRequest;
import org.example.course.core.entity.user.dto.UserReadResponse;
import org.example.course.core.repository.UserRepository;
import org.example.course.utility.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class UserReadService {
    UserRepository userRepository;

    public UserReadResponse read(UserReadRequest dto) {
        User user = userRepository.findById(dto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        return UserReadResponse.builder()
                .username(user.getUsername())
                .build();
    }
}
