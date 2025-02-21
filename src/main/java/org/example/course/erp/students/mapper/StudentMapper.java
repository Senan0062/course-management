package org.example.course.erp.students.mapper;

import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.StudentCreateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity toEntity(StudentCreateRequest request);

    EntityById toEntityById(StudentEntity entity);
}
