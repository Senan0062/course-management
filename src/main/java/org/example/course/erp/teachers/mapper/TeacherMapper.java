package org.example.course.erp.teachers.mapper;

import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.teachers.dto.request.TeacherCreateRequest;
import org.example.course.erp.teachers.dto.request.TeacherUpdateRequest;
import org.example.course.erp.teachers.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toEntity(TeacherCreateRequest teacherCreateRequest);

    EntityById toEntityById(Teacher teacher);

    @Mapping(target = "id", ignore = true)
    Teacher updateEntity(@MappingTarget Teacher teacher, TeacherUpdateRequest teacherUpdateRequest);
}
