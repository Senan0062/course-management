package org.example.course.core.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.entity.user.UserReadService;
import org.example.course.core.entity.user.dto.UserReadRequestDto;
import org.example.course.core.entity.user.dto.UserReadResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core/test")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CoreTestController {
    UserReadService readService;

    @PostMapping("/user-read")
    public ResponseEntity<UserReadResponseDto> read(@RequestBody UserReadRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(readService.read(dto));
    }
}
