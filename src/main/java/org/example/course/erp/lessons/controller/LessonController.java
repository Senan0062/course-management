package org.example.course.erp.lessons.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.lessons.dto.request.LessonCreateRequest;
import org.example.course.erp.lessons.dto.request.LessonUpdateRequest;
import org.example.course.erp.lessons.dto.response.LessonResponse;
import org.example.course.erp.lessons.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/lessons")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class LessonController {
    LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@RequestBody LessonCreateRequest request) {
        return ResponseEntity.ok(lessonService.createLesson(request));
    }

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id, @RequestBody LessonUpdateRequest request) {
        return ResponseEntity.ok(lessonService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
