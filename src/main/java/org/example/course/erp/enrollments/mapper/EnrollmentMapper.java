package org.example.course.erp.enrollments.mapper;

import org.example.course.erp.enrollments.dto.request.EnrollmentRequest;
import org.example.course.erp.enrollments.entity.Enrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    Enrollment toEntity(EnrollmentRequest request);

}
