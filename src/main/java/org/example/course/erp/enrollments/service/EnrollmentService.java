package org.example.course.erp.enrollments.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.course.erp.enrollments.dto.request.EnrollmentRequest;
import org.example.course.erp.enrollments.dto.response.EnrollmentResponse;
import org.example.course.erp.enrollments.entity.Enrollment;
import org.example.course.erp.enrollments.mapper.EnrollmentMapper;
import org.example.course.erp.enrollments.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentResponse enrollStudent(EnrollmentRequest request) {
        Enrollment enrollment = enrollmentMapper.toEntity(request);
        return enrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public EnrollmentResponse getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return enrollmentMapper.toResponse(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
