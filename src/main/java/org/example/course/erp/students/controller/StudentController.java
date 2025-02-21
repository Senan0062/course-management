package org.example.course.erp.students.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.StudentCreateRequest;
import org.example.course.erp.students.dto.StudentUpdateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.example.course.erp.students.service.StudentCreateService;
import org.example.course.erp.students.service.StudentDeleteService;
import org.example.course.erp.students.service.StudentReadService;
import org.example.course.erp.students.service.StudentUpdateService;
import org.springframework.http.HttpStatus;
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
    StudentReadService studentReadService;
    StudentUpdateService updateService;

    @PostMapping("/create")
    public ResponseEntity<EntityById> create(@Valid @RequestBody StudentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(createService.create(request));
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@Valid @RequestBody EntityById request) {
        boolean isDeleted = deleteService.delete(request);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/read-all-students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> readAllStudents() {
        return studentReadService.readStudents();
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody StudentUpdateRequest dto) {
        updateService.updateStudent(dto);
    }
}
