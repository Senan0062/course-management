package org.example.course.erp.students.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.students.entity.StudentEntity;
import org.example.course.erp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class StudentReadService {
    StudentRepository studentRepository;

    public List<StudentEntity> readStudents() {
        return studentRepository.findAll();
    }
}
