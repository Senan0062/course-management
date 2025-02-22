package org.example.course.erp.lessons.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.lessons.dto.request.LessonCreateRequest;
import org.example.course.erp.lessons.dto.request.LessonUpdateRequest;
import org.example.course.erp.lessons.dto.response.LessonReadResponse;
import org.example.course.erp.lessons.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/lessons")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class LessonController {
    LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityById createLesson(@RequestBody LessonCreateRequest request) {
        return lessonService.createLesson(request);
    }

    @GetMapping
    public ResponseEntity<List<LessonReadResponse>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonReadResponse> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityById> updateLesson(@PathVariable Long id, @RequestBody LessonUpdateRequest request) {
        return ResponseEntity.ok(lessonService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
