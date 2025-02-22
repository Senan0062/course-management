package org.example.course.erp.teachers.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.teachers.dto.request.TeacherUpdateRequest;
import org.example.course.erp.teachers.entity.Teacher;
import org.example.course.erp.teachers.mapper.TeacherMapper;
import org.example.course.erp.teachers.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class TeacherUpdateService {
    TeacherRepository teacherRepository;
    TeacherMapper teacherMapper;

    public boolean updateTeacher(TeacherUpdateRequest teacherUpdateRequest) {
        Teacher teacher = teacherRepository.findByIdAndStatus(teacherUpdateRequest.getId(), "A");
        if (teacher == null) {
//            throw new RuntimeException("Teacher not found");
            return false;
        }
        teacher = teacherMapper.updateEntity(teacher, teacherUpdateRequest);
        teacher.setStatus("A");
        teacher.setModificationDate(LocalDateTime.now());
        teacherRepository.save(teacher);
        return true;
    }
}
