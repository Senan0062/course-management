package org.example.course.erp.enrollments.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class EnrollmentRequest {
    Long studentId;
    Long lessonId;
}
