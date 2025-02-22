package org.example.course.erp.lessons.mapper;

import org.example.course.erp.lessons.dto.request.LessonCreateRequest;
import org.example.course.erp.lessons.dto.request.LessonUpdateRequest;
import org.example.course.erp.lessons.dto.response.LessonReadResponse;
import org.example.course.erp.lessons.dto.response.LessonResponse;
import org.example.course.erp.lessons.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toEntity(LessonCreateRequest request);

    LessonResponse toResponse(Lesson entity);

    @Mapping(target = "id", ignore = true)
    Lesson updateEntity(@MappingTarget Lesson entity, LessonUpdateRequest request);
}

