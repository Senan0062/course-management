package org.example.course.erp.students.mapper;

import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.StudentCreateRequest;
import org.example.course.erp.students.dto.StudentUpdateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity toEntity(StudentCreateRequest request);

    EntityById toEntityById(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    StudentEntity studentUpdateDtoToStudent(@MappingTarget StudentEntity student, StudentUpdateRequest dto);
}
