package org.example.course.erp.enrollments.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class EnrollmentReadResponse {
    Long id;
    String studentId;
    String lessonId;
    LocalDateTime enrollmentDate;
}
