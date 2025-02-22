package org.example.course.erp.teachers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.teachers.dto.request.TeacherCreateRequest;
import org.example.course.erp.teachers.dto.request.TeacherUpdateRequest;
import org.example.course.erp.teachers.service.TeacherCreateService;
import org.example.course.erp.teachers.service.TeacherUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/teachers")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class TeacherController {
    TeacherCreateService createService;
    TeacherUpdateService updateService;

    @PostMapping
    public ResponseEntity<EntityById> createTeacher(@Valid @RequestBody TeacherCreateRequest request) {
        EntityById teacher = createService.createTeacher(request);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable Long id, @Valid @RequestBody TeacherUpdateRequest request) {
        boolean isUpdated = updateService.updateTeacher(request);
        return isUpdated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
