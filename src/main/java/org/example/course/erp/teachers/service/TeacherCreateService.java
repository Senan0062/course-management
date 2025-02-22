package org.example.course.erp.teachers.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.teachers.dto.request.TeacherCreateRequest;
import org.example.course.erp.teachers.entity.Teacher;
import org.example.course.erp.teachers.mapper.TeacherMapper;
import org.example.course.erp.teachers.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class TeacherCreateService {
    TeacherRepository teacherRepository;
    TeacherMapper teacherMapper;

    public EntityById createTeacher(TeacherCreateRequest teacherCreateRequest) {
        Teacher teacher = teacherMapper.toEntity(teacherCreateRequest);
        teacher.setStatus("A");
        teacher.setCreatedDate(LocalDateTime.now());
        teacherRepository.save(teacher);
        return  teacherMapper.toEntityById(teacher);
    }
}
