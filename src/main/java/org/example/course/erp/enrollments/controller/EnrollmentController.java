package org.example.course.erp.enrollments.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.enrollments.dto.request.EnrollmentRequest;
import org.example.course.erp.enrollments.dto.response.EnrollmentReadResponse;
import org.example.course.erp.enrollments.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/enrollments")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class EnrollmentController {
    EnrollmentService enrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityById enrollStudent(@RequestBody EnrollmentRequest request) {
        return enrollmentService.enrollStudent(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentReadResponse> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentReadResponse getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
