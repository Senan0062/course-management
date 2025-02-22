package org.example.course.erp.students.mapper;

import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.request.StudentCreateRequest;
import org.example.course.erp.students.dto.request.StudentUpdateRequest;
import org.example.course.erp.students.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentCreateRequest request);

    EntityById toEntityById(Student entity);

    @Mapping(target = "id", ignore = true)
    Student studentUpdateDtoToStudent(@MappingTarget Student student, StudentUpdateRequest dto);
}
