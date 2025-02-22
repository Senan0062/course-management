package org.example.course.erp.students.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.students.entity.Student;
import org.example.course.erp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class StudentReadService {
    StudentRepository studentRepository;

    public List<Student> readStudents() {
        return studentRepository.findAll();
    }
}
