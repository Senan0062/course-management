package org.example.course.erp.students.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.request.StudentCreateRequest;
import org.example.course.erp.students.dto.request.StudentUpdateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.example.course.erp.students.service.StudentCreateService;
import org.example.course.erp.students.service.StudentDeleteService;
import org.example.course.erp.students.service.StudentReadService;
import org.example.course.erp.students.service.StudentUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/students")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class StudentController {
    StudentCreateService createService;
    StudentDeleteService deleteService;
    StudentReadService readService;
    StudentUpdateService updateService;

    /**
     * Yeni tələbə yaradılması
     */
    @PostMapping
    public ResponseEntity<EntityById> createStudent(@Valid @RequestBody StudentCreateRequest request) {
        EntityById student = createService.create(request);
        return ResponseEntity.ok(student);
    }

    /**
     * ID-yə əsasən tələbənin silinməsi
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = deleteService.delete(new EntityById(id));
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Bütün tələbələrin oxunması
     */
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = readService.readStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Tələbənin məlumatlarını yeniləmə
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentUpdateRequest dto) {
        updateService.updateStudent(dto);
        return ResponseEntity.noContent().build();
    }
}