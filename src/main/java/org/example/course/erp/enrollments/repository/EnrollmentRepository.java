package org.example.course.erp.enrollments.repository;

import org.example.course.erp.enrollments.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
