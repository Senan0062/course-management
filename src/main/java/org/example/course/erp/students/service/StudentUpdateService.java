package org.example.course.erp.students.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.students.dto.StudentUpdateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.example.course.erp.students.mapper.StudentMapper;
import org.example.course.erp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class StudentUpdateService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    public void updateStudent(StudentUpdateRequest dto) {
        StudentEntity student = studentRepository.findByIdAndStatus(dto.getId(), "A");
        student = studentMapper.studentUpdateDtoToStudent(student, dto);
        student.setStatus("A");
        student.setModificationDate(LocalDateTime.now());
        studentRepository.save(student);
    }
}
