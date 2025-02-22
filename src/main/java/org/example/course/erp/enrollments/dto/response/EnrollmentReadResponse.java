package org.example.course.erp.enrollments.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentReadResponse {
    Long id;
    String studentId;
    String lessonId;
    LocalDateTime enrollmentDate;
}
