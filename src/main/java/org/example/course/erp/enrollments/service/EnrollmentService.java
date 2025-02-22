package org.example.course.erp.enrollments.service;

import lombok.RequiredArgsConstructor;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.enrollments.dto.request.EnrollmentRequest;
import org.example.course.erp.enrollments.dto.response.EnrollmentReadResponse;
import org.example.course.erp.enrollments.entity.Enrollment;
import org.example.course.erp.enrollments.mapper.EnrollmentMapper;
import org.example.course.erp.enrollments.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EntityById enrollStudent(EnrollmentRequest request) {
        Enrollment enrollment = enrollmentMapper.toEntity(request);
        enrollment.setStatus("A");
        enrollment.setEnrollmentDate(LocalDateTime.now());
        return EntityById.builder()
                .id(enrollmentRepository.save(enrollment).getId())
                .build();
    }

    public List<EnrollmentReadResponse> getAllEnrollments() {
        return enrollmentRepository.findAllByStatus("A")
                .stream()
                .toList();
    }

    public EnrollmentReadResponse getEnrollmentById(Long id) {
        return enrollmentRepository.findByIdAndStatus(id, "A")
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
