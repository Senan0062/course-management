package org.example.course.erp.enrollments.repository;

import org.example.course.erp.enrollments.dto.response.EnrollmentReadResponse;
import org.example.course.erp.enrollments.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("""
            SELECT new org.example.course.erp.enrollments.dto.response.EnrollmentReadResponse(
            e.id,
            s.firstName || ' ' || s.lastName,
            l.title,
            e.enrollmentDate
            )
            FROM Enrollment e
            left join Student s on e.studentId = s.id
            left join Lesson l on e.lessonId = l.id
            WHERE e.status = :status
            """)
    List<EnrollmentReadResponse> findAllByStatus(String status);

    @Query("""
            SELECT new org.example.course.erp.enrollments.dto.response.EnrollmentReadResponse(
            e.id,
            s.firstName || ' ' || s.lastName,
            l.title,
            e.enrollmentDate
            )
            FROM Enrollment e
            left join Student s on e.studentId = s.id
            left join Lesson l on e.lessonId = l.id
            WHERE e.id = :id AND e.status = :status
            """)
    Optional<EnrollmentReadResponse> findByIdAndStatus(Long id, String status);
}
